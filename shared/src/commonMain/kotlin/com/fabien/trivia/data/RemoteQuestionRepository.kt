package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

/**
 * Document Firestore d'une question, dans la collection `questions`.
 * L'**id du document = le slug** `Question.id` (donc pas stocké en champ ici).
 * `category` est le nom d'enum (clé stable). Défauts pour une désérialisation tolérante.
 */
@Serializable
private data class QuestionDto(
    val title: String = "",
    val text: String = "",
    val options: List<String> = emptyList(),
    val correctIndex: Int = 0,
    val rating: Int = 1000,
    val explanation: String = "",
    val category: String = "",
    val tags: List<String> = emptyList()
)

private fun Question.toDto() = QuestionDto(
    title = title,
    text = text,
    options = options,
    correctIndex = correctIndex,
    rating = rating,
    explanation = explanation,
    category = category.name,
    tags = tags
)

/**
 * Question telle qu'exportée (collection `questions` → JSON pour partager le set, p. ex. avec une IA
 * à qui demander d'en générer de nouvelles). Contrairement au [QuestionDto] interne, on **inclut le
 * slug `id`** (qui est l'id du document Firestore) car c'est lui qui porte la convention de nommage.
 */
@Serializable
private data class QuestionExportDto(
    val id: String,
    val category: String,
    val title: String,
    val text: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val rating: Int,
    val tags: List<String> = emptyList()
)

/** Résultat d'un export : le JSON formaté + le nombre de questions, pour le retour UI. */
data class QuestionsExport(val count: Int, val json: String)

private val exportJson = Json { prettyPrint = true; prettyPrintIndent = "  " }

/**
 * Source distante des questions (Firestore, collection `questions`).
 *
 * Offline-first : Firestore sert les lectures depuis son cache local quand le réseau manque
 * (après au moins une synchro réussie). Le set bundlé `QuestionRepository.questions` reste le
 * fallback initial tant que rien n'a été récupéré. Permet d'ajouter/corriger des questions
 * sans republier l'app, et garantit un jeu identique pour tous (prérequis multijoueur).
 */
class RemoteQuestionRepository(private val firestore: FirebaseFirestore = Firebase.firestore) {

    private val collection get() = firestore.collection("questions")

    /**
     * Exporte toute la collection `questions` en JSON formaté (indenté, trié par catégorie puis par
     * slug pour que la couverture et les trous sautent aux yeux). Inclut le slug `id` de chaque doc.
     * Sert à partager le set existant (sauvegarde, ou à donner à une IA pour générer de nouvelles
     * questions dans le même format).
     */
    suspend fun exportAsJson(): QuestionsExport {
        val questions = fetchAll().sortedWith(compareBy({ it.category.ordinal }, { it.id }))
        val dtos = questions.map { q ->
            QuestionExportDto(
                id = q.id,
                category = q.category.name,
                title = q.title,
                text = q.text,
                options = q.options,
                correctIndex = q.correctIndex,
                explanation = q.explanation,
                rating = q.rating,
                tags = q.tags
            )
        }
        val json = exportJson.encodeToString(ListSerializer(QuestionExportDto.serializer()), dtos)
        return QuestionsExport(count = dtos.size, json = json)
    }

    /** Récupère toutes les questions distantes. Liste vide si la collection est vide/inaccessible. */
    suspend fun fetchAll(): List<Question> {
        val snapshot = collection.get()
        return snapshot.documents.mapNotNull { doc ->
            val dto = doc.data(QuestionDto.serializer())
            val category = runCatching { Category.valueOf(dto.category) }.getOrNull()
                ?: return@mapNotNull null
            Question(
                id = doc.id,
                title = dto.title,
                text = dto.text,
                options = dto.options,
                correctIndex = dto.correctIndex,
                rating = dto.rating,
                explanation = dto.explanation,
                category = category,
                tags = dto.tags
            )
        }
    }

    /**
     * Pousse (écrase par slug) les questions fournies dans Firestore. Opération ponctuelle de
     * seeding/maintenance : nécessite des règles autorisant l'écriture sur `questions`.
     */
    suspend fun seed(questions: List<Question>) {
        questions.forEach { question ->
            collection.document(question.id).set(QuestionDto.serializer(), question.toDto())
        }
    }
}

package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

/**
 * Document Firestore d'une question, dans la collection `questions`.
 * L'**id du document = le slug** `Question.id` (donc pas stocké en champ ici).
 * `category` est le nom d'enum (clé stable). Défauts pour une désérialisation tolérante.
 */
@Serializable
private data class QuestionDto(
    val text: String = "",
    val options: List<String> = emptyList(),
    val correctIndex: Int = 0,
    val rating: Int = 1000,
    val explanation: String = "",
    val category: String = ""
)

private fun Question.toDto() = QuestionDto(
    text = text,
    options = options,
    correctIndex = correctIndex,
    rating = rating,
    explanation = explanation,
    category = category.name
)

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

    /** Récupère toutes les questions distantes. Liste vide si la collection est vide/inaccessible. */
    suspend fun fetchAll(): List<Question> {
        val snapshot = collection.get()
        return snapshot.documents.mapNotNull { doc ->
            val dto = doc.data(QuestionDto.serializer())
            val category = runCatching { Category.valueOf(dto.category) }.getOrNull()
                ?: return@mapNotNull null
            Question(
                id = doc.id,
                text = dto.text,
                options = dto.options,
                correctIndex = dto.correctIndex,
                rating = dto.rating,
                explanation = dto.explanation,
                category = category
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

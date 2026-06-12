package com.fabien.trivia.data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.EmailAuthProvider
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.FirebaseUser
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Utilisateur exposé à l'UI, indépendant du SDK Firebase (pour ne pas faire fuiter
 * les types GitLive dans le ViewModel / l'UI).
 *
 * - [isAnonymous] = compte invité : on joue tout de suite, on pourra le convertir en
 *   compte email permanent plus tard via [AuthRepository.linkEmail] sans perdre l'UID.
 */
data class AuthUser(
    val uid: String,
    val email: String?,
    val isAnonymous: Boolean
)

private fun FirebaseUser.toAuthUser() = AuthUser(
    uid = uid,
    email = email,
    isAnonymous = isAnonymous
)

/**
 * Accès à l'authentification Firebase via GitLive (code partagé Android + iOS).
 *
 * Compte **optionnel** : l'app fonctionne sans, ceci ne sert qu'à rattacher les
 * données (ratings) à un compte pour les synchroniser (cf. TODO point 1).
 */
class AuthRepository(private val auth: FirebaseAuth = Firebase.auth) {

    /** Émet l'utilisateur courant à chaque changement (connexion / déconnexion). null = déconnecté. */
    val authState: Flow<AuthUser?> = auth.authStateChanged.map { it?.toAuthUser() }

    /** Utilisateur courant lu de façon synchrone (pour l'état initial). */
    val currentUser: AuthUser? get() = auth.currentUser?.toAuthUser()

    /** Connexion invité : crée un compte anonyme. */
    suspend fun signInAnonymously() {
        auth.signInAnonymously()
    }

    suspend fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
    }

    suspend fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
    }

    /**
     * Convertit le compte invité courant en compte email permanent **en conservant l'UID**
     * (donc les données déjà rattachées à ce compte). À appeler quand l'utilisateur courant
     * est anonyme.
     */
    suspend fun linkEmail(email: String, password: String) {
        val credential = EmailAuthProvider.credential(email, password)
        auth.currentUser?.linkWithCredential(credential)
    }

    /**
     * Envoie un email de réinitialisation de mot de passe (page de saisie hébergée par Firebase).
     * Lève une exception si l'email est invalide / inconnu — l'appelant choisit de masquer ou non
     * ce détail (anti-énumération).
     */
    suspend fun sendPasswordReset(email: String) {
        auth.sendPasswordResetEmail(email)
    }

    suspend fun signOut() {
        auth.signOut()
    }
}

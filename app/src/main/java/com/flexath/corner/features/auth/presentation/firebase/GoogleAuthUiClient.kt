package com.flexath.corner.features.auth.presentation.firebase

import android.content.Intent
import android.content.IntentSender
import com.flexath.corner.BuildConfig
import com.flexath.corner.features.auth.presentation.states.RegisterResultState
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class GoogleAuthUiClient @Inject constructor(
    private val signInClient: SignInClient
) {
    private val auth = Firebase.auth

    suspend fun signIn(): IntentSender? {
        val task = try {
            signInClient.beginSignIn(
                beginSignInRequest()
            ).await()
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            null
        }
        return task?.pendingIntent?.intentSender
    }

    suspend fun signInWithIntent(intent: Intent): RegisterResultState {
        val credential = signInClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)

        return try {
            val user = auth.signInWithCredential(googleCredentials).await().user
            RegisterResultState(
                userData = user?.run {
                    UserData(
                        userId = uid,
                        username = displayName,
                        profilePictureUrl = photoUrl?.toString()
                    )
                },
                error = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            RegisterResultState(
                userData = null,
                error = e.message
            )
        }
    }

    suspend fun signOut() {
        try {
            auth.signOut()
            signInClient.signOut().await()
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
        }
    }

    private fun beginSignInRequest(): BeginSignInRequest {
        return BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(BuildConfig.FIREBASE_SERVER_SIDE_ID)
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
    }

    fun getSignInUserInformation(): UserData? = auth.currentUser?.run {
        UserData(
            userId = this.uid,
            username = this.displayName,
            profilePictureUrl = this.photoUrl.toString()
        )
    }
}
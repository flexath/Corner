package com.flexath.corner.features.auth.presentation

import android.util.Log
import com.facebook.AccessToken
import com.flexath.corner.features.auth.presentation.google_sign_in.UserData
import com.flexath.corner.features.auth.presentation.states.RegisterResultState
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class FacebookAuthUiClient @Inject constructor() {

    private val auth = Firebase.auth

    suspend fun signIn(token: AccessToken): RegisterResultState {
        Log.d("FacebookToken", "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)

        return try {
            val user = auth.signInWithCredential(credential).await().user
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

    fun signOut() {
        try {
            auth.signOut()
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
        }
    }

    fun getSignInUserInformation(): UserData? = auth.currentUser?.run {
        UserData(
            userId = this.uid,
            username = this.displayName,
            profilePictureUrl = this.photoUrl.toString()
        )
    }
}
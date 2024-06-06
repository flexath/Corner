package com.flexath.corner.features.auth.presentation.viewmodels

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.AccessToken
import com.flexath.corner.features.auth.presentation.firebase.FacebookAuthUiClient
import com.flexath.corner.features.auth.presentation.events.SignOutEvent
import com.flexath.corner.features.auth.presentation.events.SignUpEvent
import com.flexath.corner.features.auth.presentation.firebase.EmailPasswordAuthUiClient
import com.flexath.corner.features.auth.presentation.firebase.GoogleAuthUiClient
import com.flexath.corner.features.auth.presentation.states.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val googleAuthUiClient: GoogleAuthUiClient,
    private val facebookAuthUiClient: FacebookAuthUiClient,
    private val emailPasswordAuthUiClient: EmailPasswordAuthUiClient
) : ViewModel() {

    private var _registerState = MutableStateFlow(RegisterState())
    val registerState get() = _registerState.asStateFlow()

    fun onSignInEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.GoogleSignUpEvent -> {
                signInWithGoogle(event.intent)
            }

            is SignUpEvent.FacebookSignUpEvent -> {
                signInWithFacebook(event.accessToken)
            }

            is SignUpEvent.EmailSignUpEvent -> {
                signInWithEmailPassword(email = event.email, password = event.password)
            }
        }
    }

    fun onSignOutEvent(event: SignOutEvent) {
        when (event) {
            SignOutEvent.GoogleSignOutEvent -> {
                viewModelScope.launch {
                    signOutWithGoogle()
                }
            }

            SignOutEvent.FacebookSignOutEvent -> {
                signOutWithFacebook()
            }

            SignOutEvent.EmailSignOutEvent -> {

            }
        }
    }

    fun resetRegisterState() {
        _registerState.update {
            RegisterState()
        }
    }

    private fun signInWithGoogle(intent: Intent) {
        viewModelScope.launch {
            val registerResult = googleAuthUiClient.signIn(intent)
            _registerState.update {
                it.copy(
                    userData = registerResult.userData,
                    error = registerResult.error,
                    isSignInSuccessful = registerResult.userData != null
                )
            }
        }
    }

    private fun signInWithFacebook(accessToken: AccessToken) {
        viewModelScope.launch {
            val registerResult = facebookAuthUiClient.signIn(accessToken)
            _registerState.update {
                it.copy(
                    userData = registerResult.userData,
                    error = registerResult.error,
                    isSignInSuccessful = registerResult.userData != null
                )
            }
        }
    }

    private fun signInWithEmailPassword(email: String, password: String) {
        viewModelScope.launch {
            val registerResult = emailPasswordAuthUiClient.signIn(email, password)
            _registerState.update {
                it.copy(
                    userData = registerResult.userData,
                    error = registerResult.error,
                    isSignInSuccessful = registerResult.userData != null
                )
            }
        }
    }

    suspend fun signInWithGoogle() = googleAuthUiClient.signInWithIntentSender()

    private suspend fun signOutWithGoogle() {
        googleAuthUiClient.signOut()
    }

    private fun signOutWithFacebook() {
        facebookAuthUiClient.signOut()
    }

    private fun signOutWithEmailPassword() {
        emailPasswordAuthUiClient.signOut()
    }

    fun getUserInformationFromGoogle() = googleAuthUiClient.getSignInUserInformation()

    fun getUserInformationFromFacebook() = facebookAuthUiClient.getSignInUserInformation()
}
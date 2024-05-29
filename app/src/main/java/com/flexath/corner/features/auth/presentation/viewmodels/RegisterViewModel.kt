package com.flexath.corner.features.auth.presentation.viewmodels

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flexath.corner.features.auth.presentation.events.RegisterEvent
import com.flexath.corner.features.auth.presentation.google_sign_in.GoogleAuthUiClient
import com.flexath.corner.features.auth.presentation.states.RegisterResultState
import com.flexath.corner.features.auth.presentation.states.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val googleAuthUiClient: GoogleAuthUiClient
) : ViewModel() {

    private var _registerState = MutableStateFlow(RegisterState())
    val registerState get() = _registerState.asStateFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.GoogleSignUpEvent -> {
                signInWithIntent(event.intent)
            }

            RegisterEvent.FacebookSignUpEvent -> {

            }

            RegisterEvent.EmailSignUpEvent -> {

            }
        }
    }

    fun resetRegisterState() {
        _registerState.update {
            it.copy(
                userData = null,
                isSignInSuccessful = false,
                error = null
            )
        }
    }

    private fun signInWithIntent(intent: Intent) {
        viewModelScope.launch {
            val registerResult = googleAuthUiClient.signInWithIntent(intent)
            _registerState.update {
                it.copy(
                    userData = registerResult.userData,
                    error = registerResult.error,
                    isSignInSuccessful = registerResult.userData != null
                )
            }
        }
    }

    suspend fun signIn() = googleAuthUiClient.signIn()

    fun signOut() {
        viewModelScope.launch {
            googleAuthUiClient.signOut()
        }
    }

    fun getUserInformation() = googleAuthUiClient.getSignInUserInformation()
}
package com.flexath.corner.features.auth.presentation.states

data class RegisterState(
    val isSignInSuccessful: Boolean = false,
    val error: String? = null
)
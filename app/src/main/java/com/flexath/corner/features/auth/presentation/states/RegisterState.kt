package com.flexath.corner.features.auth.presentation.states

import com.flexath.corner.features.auth.presentation.firebase.UserData

data class RegisterState(
    val userData: UserData? = null,
    val isSignInSuccessful: Boolean = false,
    val error: String? = null
)
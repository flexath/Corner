package com.flexath.corner.features.auth.presentation.states

import com.flexath.corner.features.auth.presentation.google_sign_in.UserData

data class RegisterResultState(
    val userData: UserData? = null,
    val error: String? = null
)

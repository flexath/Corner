package com.flexath.corner.features.auth.presentation.states

import com.flexath.corner.features.auth.presentation.google_sign_in.UserData

data class SignInResultState(
    val userData: UserData?,
    val error: String? = null
)

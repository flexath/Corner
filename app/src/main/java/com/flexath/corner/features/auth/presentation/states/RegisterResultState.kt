package com.flexath.corner.features.auth.presentation.states

import com.flexath.corner.features.auth.presentation.firebase.UserData

data class RegisterResultState(
    val userData: UserData? = null,
    val error: String? = null
)

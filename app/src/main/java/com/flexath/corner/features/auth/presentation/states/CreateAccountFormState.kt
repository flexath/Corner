package com.flexath.corner.features.auth.presentation.states

data class CreateAccountFormState(
    val fullName: String = "",
    val fullNameError: String? = null,
    val email: String = "",
    val emailError: String? = null
)

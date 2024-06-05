package com.flexath.corner.features.auth.presentation.states

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorMsg: String? = null
)

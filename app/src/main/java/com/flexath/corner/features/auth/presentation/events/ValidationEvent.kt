package com.flexath.corner.features.auth.presentation.events

sealed class ValidationEvent {
    data object Success: ValidationEvent()
    data object Failed: ValidationEvent()
}
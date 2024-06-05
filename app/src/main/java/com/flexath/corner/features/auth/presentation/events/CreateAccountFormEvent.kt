package com.flexath.corner.features.auth.presentation.events

sealed class CreateAccountFormEvent {
    data class UserNameChanged(val userName: String) : CreateAccountFormEvent()
    data class EmailChanged(val email: String) : CreateAccountFormEvent()
    data object Submit: CreateAccountFormEvent()
}
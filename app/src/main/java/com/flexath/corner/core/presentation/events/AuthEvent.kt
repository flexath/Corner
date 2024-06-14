package com.flexath.corner.core.presentation.events

sealed class AuthEvent {
    data object SaveAppEntry : AuthEvent()
}
package com.flexath.corner.features.auth.presentation.events

sealed class SignOutEvent {
    data object GoogleSignOutEvent : SignOutEvent()
    data object FacebookSignOutEvent : SignOutEvent()
    data object EmailSignOutEvent : SignOutEvent()
}
package com.flexath.corner.core.presentation.events

sealed class AppCoreEvent() {
    data object AuthEvent : AppCoreEvent()
}
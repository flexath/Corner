package com.flexath.corner.features.main.presentation.events

sealed class MainWidgetEvent {
    data class BecomeAFriendDialog(val isShown: Boolean) : MainWidgetEvent()
}
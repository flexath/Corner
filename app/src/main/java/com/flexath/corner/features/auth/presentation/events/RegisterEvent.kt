package com.flexath.corner.features.auth.presentation.events

import android.content.Intent

sealed class RegisterEvent{
    data class GoogleSignUpEvent(val intent: Intent): RegisterEvent()
    data object FacebookSignUpEvent: RegisterEvent()
    data object EmailSignUpEvent: RegisterEvent()
}
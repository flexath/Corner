package com.flexath.corner.features.auth.presentation.events

sealed class RegisterEvent{
    data object GoogleSignUpEvent: RegisterEvent()
    data object FacebookSignUpEvent: RegisterEvent()
    data object EmailSignUpEvent: RegisterEvent()
}
package com.flexath.corner.features.auth.presentation.events

import android.content.Intent
import com.facebook.AccessToken

sealed class SignUpEvent{
    data class GoogleSignUpEvent(val intent: Intent): SignUpEvent()
    data class FacebookSignUpEvent(val accessToken: AccessToken) : SignUpEvent()
    data object EmailSignUpEvent: SignUpEvent()
}
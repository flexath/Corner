package com.flexath.corner.features.auth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.flexath.corner.features.auth.presentation.events.RegisterEvent
import com.flexath.corner.features.auth.presentation.states.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(

): ViewModel() {

    private var _authState = MutableStateFlow(RegisterState())
    val registerState get() = _authState.asStateFlow()

    fun onEvent(event: RegisterEvent) {

    }
}
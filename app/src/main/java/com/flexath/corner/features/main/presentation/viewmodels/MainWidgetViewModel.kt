package com.flexath.corner.features.main.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.flexath.corner.features.main.presentation.events.MainWidgetEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainWidgetViewModel @Inject constructor(

): ViewModel() {

    private var _isBecomeAFriendDialogShown = MutableStateFlow(false)
    val isBecomeAFriendDialogShown = _isBecomeAFriendDialogShown.asStateFlow()

    fun onWidgetEvent(event: MainWidgetEvent) {
        when(event) {
            is MainWidgetEvent.BecomeAFriendDialog -> {
                _isBecomeAFriendDialogShown.update {
                    event.isShown
                }
            }
        }
    }
}
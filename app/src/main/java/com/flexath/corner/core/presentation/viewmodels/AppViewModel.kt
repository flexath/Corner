package com.flexath.corner.core.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flexath.corner.core.domain.usecases.AppEntryUseCase
import com.flexath.corner.core.presentation.events.AuthEvent
import com.flexath.corner.core.presentation.nav_graphs.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
): ViewModel() {

    private var _startDestination = MutableStateFlow("")
    val startDestination get() = _startDestination.asStateFlow()

    init {
        readAppEntry()
    }

    fun onEvent(event: AuthEvent) {
        when(event) {
            is AuthEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun readAppEntry() {
        appEntryUseCase.readAppEntry.invoke()
            .onEach {
                _startDestination.update { _ ->
                    if(it) {
                        Route.MainSubGraph.route
                    } else {
                        Route.AuthSubGraph.route
                    }
                }
            }.launchIn(viewModelScope)
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCase.saveAppEntry.invoke()
        }
    }
}
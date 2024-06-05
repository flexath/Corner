package com.flexath.corner.features.auth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flexath.corner.core.domain.usecases.AppEntryUseCase
import com.flexath.corner.core.presentation.events.AppCoreEvent
import com.flexath.corner.features.auth.domain.usecases.CreateAccountUseCases
import com.flexath.corner.features.auth.presentation.events.CreateAccountFormEvent
import com.flexath.corner.features.auth.presentation.events.ValidationEvent
import com.flexath.corner.features.auth.presentation.states.CreateAccountFormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val createAccountUseCases: CreateAccountUseCases,
    private val appEntryUseCase: AppEntryUseCase
): ViewModel() {

    private var _createAccountState = MutableStateFlow(CreateAccountFormState())
    val createAccountState get() = _createAccountState.asStateFlow()

    private var _validationEvent = Channel<ValidationEvent>()
    val validationEvent get() = _validationEvent.receiveAsFlow()

    fun onEvent(event: AppCoreEvent) {
        when(event) {
            is AppCoreEvent.AuthEvent -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCase.saveAppEntry.invoke()
        }
    }

    fun onCreateAccountEvent(event: CreateAccountFormEvent) {
        viewModelScope.launch(Dispatchers.Default) {
            when(event) {
                is CreateAccountFormEvent.UserNameChanged -> {
                    _createAccountState.update {
                        it.copy(
                            fullName = event.userName,
                            fullNameError = null
                        )
                    }
                }
                is CreateAccountFormEvent.EmailChanged -> {
                    _createAccountState.update {
                        it.copy(
                            email = event.email,
                            emailError = null
                        )
                    }
                }
                CreateAccountFormEvent.Submit -> {
                    submitRegistration()
                }
            }
        }
    }

    private fun submitRegistration() {
        val userNameResult = createAccountUseCases.userNameValidation.invoke(_createAccountState.value.fullName)
        val emailResult = createAccountUseCases.emailValidation.invoke(_createAccountState.value.email)

        val hasError = listOf(
            userNameResult,
            emailResult
        ).any {
            !it.isSuccessful
        }

        if(hasError) {
            viewModelScope.launch {
                _createAccountState.value = createAccountState.value.copy(
                    fullNameError = userNameResult.errorMsg,
                    emailError = emailResult.errorMsg
                )
                _validationEvent.send(ValidationEvent.Failed)
            }
            return
        }

        viewModelScope.launch {
            _validationEvent.send(ValidationEvent.Success)
        }
    }
}
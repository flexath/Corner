package com.flexath.corner.features.auth.domain.usecases

import com.flexath.corner.features.auth.domain.usecases.validation.UserNameValidation
import com.flexath.corner.features.auth.domain.usecases.validation.EmailValidation
import javax.inject.Inject

data class CreateAccountUseCases @Inject constructor(
    val userNameValidation: UserNameValidation,
    val emailValidation: EmailValidation,
)

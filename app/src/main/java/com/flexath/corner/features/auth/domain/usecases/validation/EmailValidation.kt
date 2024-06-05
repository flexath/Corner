package com.flexath.corner.features.auth.domain.usecases.validation

import com.flexath.corner.features.auth.presentation.states.ValidationResult
import javax.inject.Inject

class EmailValidation @Inject constructor() {
    operator fun invoke(
        input: String
    ): ValidationResult {
        if(!isEmpty(input)) {
            return ValidationResult(
                isSuccessful = false,
                errorMsg = "Email can't be empty"
            )
        }

        if(!isValidEmail(input)) {
            return ValidationResult(
                isSuccessful = false,
                errorMsg = "That's not a valid email"
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }

    private fun isEmpty(input: String): Boolean {
        return input.isNotBlank()
    }

    private fun isValidEmail(input: String): Boolean {
        val emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
        return input.matches(emailPattern.toRegex())
    }
}
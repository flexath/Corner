package com.flexath.corner.features.auth.di

import com.flexath.corner.features.auth.domain.usecases.CreateAccountUseCases
import com.flexath.corner.features.auth.domain.usecases.validation.EmailValidation
import com.flexath.corner.features.auth.domain.usecases.validation.UserNameValidation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CreateAccountModule {

    @Provides
    fun provideRegistrationUseCases(
        userNameValidation: UserNameValidation,
        emailValidation: EmailValidation
    ): CreateAccountUseCases {
        return CreateAccountUseCases(
            userNameValidation,
            emailValidation
        )
    }

    @Provides
    fun provideUserNameValidation(): UserNameValidation {
        return UserNameValidation()
    }

    @Provides
    fun provideEmailValidation(): EmailValidation {
        return EmailValidation()
    }
}
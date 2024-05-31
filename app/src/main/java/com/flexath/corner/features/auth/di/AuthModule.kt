package com.flexath.corner.features.auth.di

import android.content.Context
import com.flexath.corner.features.auth.presentation.firebase.EmailPasswordAuthUiClient
import com.flexath.corner.features.auth.presentation.firebase.FacebookAuthUiClient
import com.flexath.corner.features.auth.presentation.firebase.GoogleAuthUiClient
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    fun provideGoogleAuthUiClient(
        @ApplicationContext context: Context
    ): GoogleAuthUiClient {
        return GoogleAuthUiClient(provideSignInClient(context))
    }

    @Provides
    fun provideSignInClient(@ApplicationContext context: Context): SignInClient = Identity.getSignInClient(context)

    @Provides
    fun provideFacebookAuthUiClient(): FacebookAuthUiClient {
        return FacebookAuthUiClient()
    }

    @Provides
    fun provideEmailPasswordAuthUiClient(): EmailPasswordAuthUiClient {
        return EmailPasswordAuthUiClient()
    }
}
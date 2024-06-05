package com.flexath.corner.core.di

import android.content.Context
import com.flexath.corner.core.data.manager.LocalUserManagerImpl
import com.flexath.corner.core.domain.manager.LocalUserManager
import com.flexath.corner.core.domain.usecases.AppEntryUseCase
import com.flexath.corner.core.domain.usecases.ReadAppEntryUseCase
import com.flexath.corner.core.domain.usecases.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(@ApplicationContext context: Context): LocalUserManager =
        LocalUserManagerImpl(context)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager): AppEntryUseCase =
        AppEntryUseCase(
            readAppEntry = ReadAppEntryUseCase(localUserManager),
            saveAppEntry = SaveAppEntryUseCase(localUserManager)
        )
}
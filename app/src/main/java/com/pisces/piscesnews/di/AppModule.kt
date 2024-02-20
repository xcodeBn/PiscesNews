package com.pisces.piscesnews.di

import android.app.Application
import com.pisces.piscesnews.data.manager.LocalUserManagerImplementation
import com.pisces.piscesnews.domain.manager.LocalUserManager
import com.pisces.piscesnews.domain.usecases.app_entry.AppEntryUseCases
import com.pisces.piscesnews.domain.usecases.app_entry.ReadAppEntry
import com.pisces.piscesnews.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providLocalUserManager(
        application: Application
    ):LocalUserManager = LocalUserManagerImplementation(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager:LocalUserManager): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


}
package com.kryptkode.core.di

import com.kryptkode.commonandroid.logger.Logger
import com.kryptkode.commonandroid.logger.LoggerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLogger(): Logger {
        return LoggerImpl()
    }
}
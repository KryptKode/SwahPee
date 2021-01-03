package com.kryptkode.core.di

import com.kryptkode.core.dispatcher.SwahPeeDispatchers
import com.kryptkode.domain.dispatchers.AppDispatchers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DispatcherModule {

    @Binds
    @Singleton
    fun provideDispatcher(swahPeeDispatchers: SwahPeeDispatchers): AppDispatchers
}
package com.kryptkode.core.di

import com.kryptkode.data.charactersearch.remote.CharacterDetailRemote
import com.kryptkode.data.charactersearch.remote.SearchCharactersRemote
import com.kryptkode.remote.CharacterDetailRemoteImpl
import com.kryptkode.remote.SearchCharactersRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteModule {

    @Binds
    @Singleton
    fun provideCharacterDetailRemote(remote: CharacterDetailRemoteImpl): CharacterDetailRemote

    @Binds
    @Singleton
    fun provideSearchCharactersRemote(remote: SearchCharactersRemoteImpl): SearchCharactersRemote
}
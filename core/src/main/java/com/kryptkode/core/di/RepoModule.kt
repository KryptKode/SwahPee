package com.kryptkode.core.di

import com.kryptkode.core.BuildConfig
import com.kryptkode.data.charactersearch.CharacterDetailRepositoryImpl
import com.kryptkode.data.charactersearch.SearchCharactersRepositoryImpl
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.charactersearch.repo.SearchCharactersRepository
import com.kryptkode.remote.api.SwahPeeServiceApi
import com.kryptkode.remote.api.SwahPeeServiceApiFactory
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    @Singleton
    fun provideCharacterDetailRepository(repo: CharacterDetailRepositoryImpl): CharacterDetailRepository

    @Binds
    @Singleton
    fun provideSearchCharactersRepository(repo: SearchCharactersRepositoryImpl): SearchCharactersRepository


    companion object {

        @Provides
        @Singleton
        fun provideMoshi(): Moshi {
            return Moshi.Builder().build()
        }

        @Provides
        fun provideSwahPeeService(moshi: Moshi): SwahPeeServiceApi {
            return SwahPeeServiceApiFactory.makeSwahPeeService(moshi, BuildConfig.DEBUG)
        }
    }
}
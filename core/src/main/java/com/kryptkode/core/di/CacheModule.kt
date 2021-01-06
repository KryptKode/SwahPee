package com.kryptkode.core.di

import android.content.Context
import com.kryptkode.cache.AppDatabase
import com.kryptkode.cache.CharacterCacheImpl
import com.kryptkode.cache.character.CharacterDao
import com.kryptkode.data.charactersearch.cache.CharacterCache
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CacheModule {

    @Binds
    @Singleton
    fun provideCharacterCache(characterCacheImpl: CharacterCacheImpl): CharacterCache

    companion object {

        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
            return AppDatabase.getInstance(context)
        }

        @Provides
        @Singleton
        fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao {
            return appDatabase.charactersDao()
        }
    }
}
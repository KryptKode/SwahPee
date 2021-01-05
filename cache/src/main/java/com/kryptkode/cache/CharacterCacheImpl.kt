package com.kryptkode.cache

import com.kryptkode.cache.mapper.DbCharacterMapper
import com.kryptkode.data.charactersearch.cache.CharacterCache
import com.kryptkode.data.charactersearch.entities.CharacterInfoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CharacterCacheImpl @Inject constructor(
    private val mapper: DbCharacterMapper,
    appDatabase: AppDatabase
) : CharacterCache  {

    private val characterDao = appDatabase.charactersDao()

    override fun getCharacter(characterUrl: String): Flow<CharacterInfoEntity> {
        return characterDao.getCharacter(characterUrl).map {
            mapper.mapFromEntity(it)
        }
    }

    override suspend fun saveCharacter(characterList: List<CharacterInfoEntity>) {
        return characterDao.insert(characterList.map {
            mapper.mapToEntity(it)
        })
    }
}
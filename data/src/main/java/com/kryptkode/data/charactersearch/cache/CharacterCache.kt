package com.kryptkode.data.charactersearch.cache

import com.kryptkode.data.charactersearch.entities.CharacterInfoEntity
import kotlinx.coroutines.flow.Flow

interface CharacterCache {
    suspend fun saveCharacter(characterList: List<CharacterInfoEntity>)
    fun getCharacter(characterUrl:String): Flow<CharacterInfoEntity>
}
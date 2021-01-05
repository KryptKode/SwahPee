package com.kryptkode.data.charactersearch.remote

import com.kryptkode.data.charactersearch.entities.CharacterInfoEntity

interface SearchCharactersRemote {
    suspend fun searchCharacters(query: String): List<CharacterInfoEntity>
}
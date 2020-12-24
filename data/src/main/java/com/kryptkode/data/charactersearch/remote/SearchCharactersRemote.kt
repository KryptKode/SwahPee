package com.kryptkode.data.charactersearch.remote

import com.kryptkode.data.charactersearch.entities.CharacterEntity

interface SearchCharactersRemote {
    suspend fun searchCharacters(query: String): List<CharacterEntity>
}
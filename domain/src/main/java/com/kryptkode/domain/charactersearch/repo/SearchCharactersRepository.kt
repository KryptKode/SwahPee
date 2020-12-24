package com.kryptkode.domain.charactersearch.repo

import com.kryptkode.domain.charactersearch.entities.Character
import kotlinx.coroutines.flow.Flow

interface SearchCharactersRepository {
    fun searchCharacters(query: String): Flow<List<Character>>
}
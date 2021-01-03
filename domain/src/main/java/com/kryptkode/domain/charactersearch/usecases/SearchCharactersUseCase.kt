package com.kryptkode.domain.charactersearch.usecases

import com.kryptkode.domain.charactersearch.entities.Character
import com.kryptkode.domain.charactersearch.repo.SearchCharactersRepository
import com.kryptkode.domain.dispatchers.AppDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SearchCharactersUseCase @Inject constructor(
    private val appDispatchers: AppDispatchers,
    private val searchCharactersRepository: SearchCharactersRepository
) {
    fun searchCharacters(query: String): Flow<List<Character>> {
        return searchCharactersRepository.searchCharacters(query).flowOn(appDispatchers.io)
    }
}
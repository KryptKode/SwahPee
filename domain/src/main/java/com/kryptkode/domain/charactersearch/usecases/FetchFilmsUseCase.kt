package com.kryptkode.domain.charactersearch.usecases

import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.dispatchers.AppDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class FetchFilmsUseCase(
        private val appDispatchers: AppDispatchers,
        private val repository: CharacterDetailRepository) {

    fun fetchFilms(urls: List<String>): Flow<List<Film>> {
        if (urls.isEmpty()) {
            return flowOf(emptyList())
        }
        return repository.fetchFilms(urls).flowOn(appDispatchers.io)
    }
}
package com.kryptkode.domain.charactersearch.usecases

import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.dispatchers.AppDispatchers

class FetchFilmsUseCase(
    private val appDispatchers: AppDispatchers,
    private val repository: CharacterDetailRepository
) {

}
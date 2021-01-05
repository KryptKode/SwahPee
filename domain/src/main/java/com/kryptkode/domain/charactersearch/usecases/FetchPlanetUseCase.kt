package com.kryptkode.domain.charactersearch.usecases

import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.entities.Planet.Companion.NO_PLANET
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.dispatchers.AppDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchPlanetUseCase @Inject constructor(private val dispatchers: AppDispatchers,
                         private val repository: CharacterDetailRepository) {

    fun fetchPlanet(planetUrl: String): Flow<Planet> {
        if(planetUrl.isEmpty()){
            return flowOf(NO_PLANET)
        }
        return repository.fetchPlanet(planetUrl).flowOn(dispatchers.io)
    }


}
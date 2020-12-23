package com.kryptkode.data.charactersearch

import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.entities.Specie
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import kotlinx.coroutines.flow.Flow

class CharacterDetailRepositoryImpl : CharacterDetailRepository {

    override fun fetchFilms(urls: List<String>): Flow<List<Film>> {
        TODO()
    }

    override fun fetchPlanet(planetUrl: String): Flow<Planet> {
        TODO()
    }

    override fun fetchSpecies(urls: List<String>): Flow<List<Specie>> {
        TODO()
    }
}
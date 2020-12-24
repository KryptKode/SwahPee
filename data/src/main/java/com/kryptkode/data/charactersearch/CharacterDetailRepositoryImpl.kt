package com.kryptkode.data.charactersearch

import com.kryptkode.data.charactersearch.mapper.FilmMapper
import com.kryptkode.data.charactersearch.mapper.PlanetMapper
import com.kryptkode.data.charactersearch.mapper.SpecieMapper
import com.kryptkode.data.charactersearch.remote.CharacterDetailRemote
import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.entities.Specie
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterDetailRepositoryImpl @Inject constructor(
        private val remote: CharacterDetailRemote,
        private val filmMapper: FilmMapper,
        private val planetMapper: PlanetMapper,
        private val specieMapper: SpecieMapper
) : CharacterDetailRepository {

    override fun fetchFilms(urls: List<String>): Flow<List<Film>> {
        return flow {
            emit(remote.fetchFilms(urls).map {
                filmMapper.mapFromEntity(it)
            })
        }
    }

    override fun fetchPlanet(planetUrl: String): Flow<Planet> {
        return flow {
            emit(planetMapper.mapFromEntity(remote.fetchPlanet(planetUrl)))
        }
    }

    override fun fetchSpecies(urls: List<String>): Flow<List<Specie>> {
        return flow {
            emit(remote.fetchSpecies(urls).map {
                specieMapper.mapFromEntity(it)
            })
        }
    }
}
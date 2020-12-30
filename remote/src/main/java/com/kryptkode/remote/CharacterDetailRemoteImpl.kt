package com.kryptkode.remote

import com.kryptkode.data.charactersearch.entities.FilmEntity
import com.kryptkode.data.charactersearch.entities.PlanetEntity
import com.kryptkode.data.charactersearch.entities.SpecieEntity
import com.kryptkode.data.charactersearch.remote.CharacterDetailRemote
import com.kryptkode.remote.api.SwahPeeServiceApi
import com.kryptkode.remote.mapper.FilmRemoteMapper
import com.kryptkode.remote.mapper.PlanetRemoteMapper
import com.kryptkode.remote.mapper.SpecieRemoteMapper
import javax.inject.Inject

class CharacterDetailRemoteImpl @Inject constructor(
        private val serviceApi: SwahPeeServiceApi,
        private val filmRemoteMapper: FilmRemoteMapper,
        private val planetRemoteMapper: PlanetRemoteMapper,
        private val specieRemoteMapper: SpecieRemoteMapper
) : CharacterDetailRemote {

    override suspend fun fetchFilms(urls: List<String>): List<FilmEntity> {
        return urls.map { url ->
            serviceApi.getFilmDetails(url)
        }.map { film ->
            filmRemoteMapper.mapToEntity(film)
        }
    }

    override suspend fun fetchPlanet(planetUrl: String): PlanetEntity {
        return planetRemoteMapper.mapToEntity(serviceApi.getPlanet(planetUrl))
    }

    override suspend fun fetchSpecies(urls: List<String>): List<SpecieEntity> {
        return urls.map { url ->
            serviceApi.getSpecieDetails(url)
        }.map { specie ->
            specieRemoteMapper.mapToEntity(specie)
        }
    }
}
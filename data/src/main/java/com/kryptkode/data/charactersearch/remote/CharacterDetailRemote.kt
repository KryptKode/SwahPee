package com.kryptkode.data.charactersearch.remote

import com.kryptkode.data.charactersearch.entities.FilmEntity
import com.kryptkode.data.charactersearch.entities.PlanetEntity
import com.kryptkode.data.charactersearch.entities.SpecieEntity

interface CharacterDetailRemote {
    suspend fun fetchPlanet(planetUrl: String): PlanetEntity

    suspend fun fetchSpecies(urls: List<String>): List<SpecieEntity>

    suspend fun fetchFilms(urls: List<String>): List<FilmEntity>
}
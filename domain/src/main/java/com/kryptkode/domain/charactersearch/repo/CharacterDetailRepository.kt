package com.kryptkode.domain.charactersearch.repo

import com.kryptkode.domain.charactersearch.entities.CharacterInfo
import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.entities.Specie
import kotlinx.coroutines.flow.Flow

interface CharacterDetailRepository {
    fun fetchPlanet(planetUrl: String): Flow<Planet>

    fun fetchSpecies(urls: List<String>): Flow<List<Specie>>

    fun fetchFilms(urls: List<String>): Flow<List<Film>>

    fun getCharacterInfo(characterUrl: String): Flow<CharacterInfo>

    suspend fun saveCharacterInfo(characters:List<CharacterInfo>)
}
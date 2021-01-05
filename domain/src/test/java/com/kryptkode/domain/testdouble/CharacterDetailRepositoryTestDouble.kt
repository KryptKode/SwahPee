package com.kryptkode.domain.testdouble

import com.kryptkode.domain.charactersearch.entities.CharacterInfo
import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.entities.Specie
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.utils.MockDataFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CharacterDetailRepositoryTestDouble : CharacterDetailRepository {

    var filmUrls = listOf<String>()
    var planetUrl = ""
    var characterUrl = ""
    var speciesUrls = listOf<String>()

    override fun fetchFilms(urls: List<String>): Flow<List<Film>> {
        filmUrls = urls
        return flowOf(
            listOf(
                MockDataFactory.makeDomainFilm(),
                MockDataFactory.makeDomainFilm()
            )
        )
    }

    override fun fetchPlanet(planetUrl: String): Flow<Planet> {
        this.planetUrl = planetUrl
        return flowOf(MockDataFactory.makeDomainPlanet())
    }

    override fun fetchSpecies(urls: List<String>): Flow<List<Specie>> {
        this.speciesUrls = urls
        return flowOf(listOf(MockDataFactory.makeDomainSpecie()))
    }

    override fun getCharacterInfo(characterUrl: String): Flow<CharacterInfo> {
        this.characterUrl = characterUrl
        return flowOf(MockDataFactory.makeDomainCharacterInfo())
    }

    override suspend fun saveCharacterInfo(characters: List<CharacterInfo>) {

    }
}
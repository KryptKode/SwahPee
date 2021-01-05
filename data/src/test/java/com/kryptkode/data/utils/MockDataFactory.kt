package com.kryptkode.data.utils

import com.kryptkode.data.charactersearch.entities.*
import com.kryptkode.domain.charactersearch.entities.*
import com.kryptkode.testshared.DataFactory.randomString

object MockDataFactory {

    fun makeCharacterEntity(): CharacterEntity {
        return CharacterEntity(
            randomString(),
            randomString(),
            randomString(),
            randomString(),
        )
    }

    fun makeDomainCharacter(): Character {
        return Character(
            randomString(),
            randomString(),
            randomString(),
            randomString(),
        )
    }

    fun makeCharacterInfoEntity(): CharacterInfoEntity {
        return CharacterInfoEntity(
            randomString(),
            randomString(),
            randomString(),
            randomString(),
            randomString(),
            listOf(randomString(), randomString(), randomString()),
            listOf(randomString(), randomString())
        )
    }

    fun makeDomainCharacterInfo(): CharacterInfo {
        return CharacterInfo(
            randomString(),
            randomString(),
            randomString(),
            randomString(),
            randomString(),
            listOf(randomString(), randomString(), randomString()),
            listOf(randomString(), randomString())
        )
    }

    fun makeFilmEntity(): FilmEntity {
        return FilmEntity(
            randomString(),
            randomString(),
        )
    }

    fun makeDomainFilm(): Film {
        return Film(
            randomString(),
            randomString(),
        )
    }

    fun makePlanetEntity(): PlanetEntity {
        return PlanetEntity(
            randomString(),
            randomString(),
        )
    }

    fun makeDomainPlanet(): Planet {
        return Planet(
            randomString(),
            randomString(),
        )
    }

    fun makeSpecie(): SpecieEntity {
        return SpecieEntity(
            randomString(),
            randomString(),
            randomString(),
        )
    }

    fun makeDomainSpecie(): Specie {
        return Specie(
            randomString(),
            randomString(),
            randomString(),
        )
    }
}
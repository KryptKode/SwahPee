package com.kryptkode.data.utils

import com.kryptkode.data.charactersearch.entities.CharacterEntity
import com.kryptkode.data.charactersearch.entities.FilmEntity
import com.kryptkode.data.charactersearch.entities.PlanetEntity
import com.kryptkode.data.charactersearch.entities.SpecieEntity
import com.kryptkode.domain.charactersearch.entities.Character
import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.entities.Specie
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
package com.kryptkode.domain.utils

import com.kryptkode.domain.charactersearch.entities.*
import com.kryptkode.testshared.DataFactory.randomString

object MockDataFactory {

    fun makeDomainCharacter(): Character {
        return Character(
            randomString(),
            randomString(),
            randomString(),
            randomString(),
        )
    }

    fun makeDomainCharacterInfo(): CharacterInfo {
        return CharacterInfo(
            randomString(),
            randomString(),
            randomString(),
            randomString(),
            randomString(),
            listOf(),
            listOf()
        )
    }

    fun makeDomainFilm(): Film {
        return Film(
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

    fun makeDomainSpecie(): Specie {
        return Specie(
            randomString(),
            randomString(),
            randomString(),
        )
    }
}
package com.kryptkode.domain.utils

import com.kryptkode.domain.charactersearch.entities.Character
import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.entities.Specie
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
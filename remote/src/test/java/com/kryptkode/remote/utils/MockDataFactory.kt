package com.kryptkode.remote.utils

import com.kryptkode.remote.entities.character.CharacterRemote
import com.kryptkode.remote.entities.film.FilmRemote
import com.kryptkode.remote.entities.planet.PlanetRemote
import com.kryptkode.remote.entities.specie.SpecieRemote
import com.kryptkode.testshared.DataFactory.randomString

object MockDataFactory {

    fun makeCharacterRemote(): CharacterRemote {
        return CharacterRemote(
            randomString(),
            randomString(),
            randomString(),
            mutableListOf(),
            randomString(),
            mutableListOf(),
            randomString(),
        )
    }

    fun makeFilmRemote(): FilmRemote {
        return FilmRemote(
            randomString(),
            randomString(),
        )
    }

    fun makePlanetRemote(): PlanetRemote {
        return PlanetRemote(
            randomString(),
            randomString(),
        )
    }


    fun makeSpecieRemote(): SpecieRemote {
        return SpecieRemote(
            randomString(),
            randomString(),
            randomString(),
        )
    }
}
package com.kryptkode.domain.utils

import com.kryptkode.domain.charactersearch.entities.Character
import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.utils.DataFactory.randomString

object MockDataFactory {

    fun makeCharacter(): Character {
        return Character(
            randomString(),
            randomString(),
            randomString(),
            randomString(),
        )
    }

    fun makeFilm(): Film {
        return Film(
                randomString(),
                randomString(),
        )
    }
}
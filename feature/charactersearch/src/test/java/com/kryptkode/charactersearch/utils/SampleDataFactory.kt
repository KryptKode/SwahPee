package com.kryptkode.charactersearch.utils

import com.kryptkode.charactersearch.UiCharacter
import com.kryptkode.domain.charactersearch.entities.Character
import com.kryptkode.testshared.DataFactory.randomString

object SampleDataFactory {

    fun makeUiCharacter(): UiCharacter {
        return UiCharacter(
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

}
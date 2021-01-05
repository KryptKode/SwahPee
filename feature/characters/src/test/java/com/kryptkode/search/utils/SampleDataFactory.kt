package com.kryptkode.search.utils

import com.kryptkode.characters.entities.CharacterUi
import com.kryptkode.domain.charactersearch.entities.Character
import com.kryptkode.testshared.DataFactory.randomString

object SampleDataFactory {

    fun makeUiCharacter(): CharacterUi {
        return CharacterUi(
            randomString(),
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
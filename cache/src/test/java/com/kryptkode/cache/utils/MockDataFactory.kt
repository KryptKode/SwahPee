package com.kryptkode.cache.utils

import com.kryptkode.cache.character.DbCharacter
import com.kryptkode.data.charactersearch.entities.CharacterInfoEntity
import com.kryptkode.testshared.DataFactory.randomString

object MockDataFactory {

    fun makeCharacterEntity(): DbCharacter {
        return DbCharacter(
            randomString(),
            randomString(),
            randomString(),
            randomString(),
            randomString(),
            listOf(randomString(), randomString(), randomString()),
            listOf(randomString(), randomString())
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
}
package com.kryptkode.remote.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.remote.utils.MockDataFactory
import org.junit.Before
import org.junit.Test

class CharacterRemoteMapperTest {
    private lateinit var sut: CharacterRemoteMapper

    @Before
    fun setup(){
        sut = CharacterRemoteMapper()
    }

    @Test
    fun `map to entity maps data`(){

        val testCharacter = MockDataFactory.makeCharacterRemote()
        val result = sut.mapToEntity(testCharacter)

        assertThat(result.birthYear).isEqualTo(testCharacter.birthYear)
        assertThat(result.height).isEqualTo(testCharacter.height)
        assertThat(result.name).isEqualTo(testCharacter.name)
        assertThat(result.url).isEqualTo(testCharacter.url)
    }
}
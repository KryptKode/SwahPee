package com.kryptkode.data.charactersearch.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.data.utils.MockDataFactory
import org.junit.Before
import org.junit.Test


class CharacterMapperTest {

    private lateinit var SUT: CharacterMapper

    @Before
    fun setUp() {
        SUT = CharacterMapper()
    }

    @Test
    fun `map from entity maps data`() {
        val mockCharacter = MockDataFactory.makeCharacterEntity()

        val result = SUT.mapFromEntity(mockCharacter)

        assertThat(result.birthYear).isEqualTo(mockCharacter.birthYear)
        assertThat(result.height).isEqualTo(mockCharacter.height)
        assertThat(result.name).isEqualTo(mockCharacter.name)
        assertThat(result.url).isEqualTo(mockCharacter.url)
    }

    @Test
    fun `map to entity maps data`() {
        val mockCharacter = MockDataFactory.makeDomainCharacter()

        val result = SUT.mapToEntity(mockCharacter)

        assertThat(result.birthYear).isEqualTo(mockCharacter.birthYear)
        assertThat(result.height).isEqualTo(mockCharacter.height)
        assertThat(result.name).isEqualTo(mockCharacter.name)
        assertThat(result.url).isEqualTo(mockCharacter.url)
    }
}
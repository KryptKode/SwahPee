package com.kryptkode.charactersearch.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.charactersearch.utils.SampleDataFactory
import org.junit.Before
import org.junit.Test


class CharacterUiDomainMapperTest {
    private lateinit var sut: CharacterUiDomainMapper

    @Before
    fun setUp() {
        sut = CharacterUiDomainMapper()
    }

    @Test
    fun `map from entity maps data`() {
        val mockCharacter = SampleDataFactory.makeUiCharacter()

        val result = sut.mapFromEntity(mockCharacter)

        assertThat(result.birthYear).isEqualTo(mockCharacter.birthYear)
        assertThat(result.height).isEqualTo(mockCharacter.height)
        assertThat(result.name).isEqualTo(mockCharacter.name)
        assertThat(result.url).isEqualTo(mockCharacter.url)
    }

    @Test
    fun `map to entity maps data`() {
        val mockCharacter = SampleDataFactory.makeDomainCharacter()

        val result = sut.mapToEntity(mockCharacter)

        assertThat(result.birthYear).isEqualTo(mockCharacter.birthYear)
        assertThat(result.height).isEqualTo(mockCharacter.height)
        assertThat(result.name).isEqualTo(mockCharacter.name)
        assertThat(result.url).isEqualTo(mockCharacter.url)
    }
}
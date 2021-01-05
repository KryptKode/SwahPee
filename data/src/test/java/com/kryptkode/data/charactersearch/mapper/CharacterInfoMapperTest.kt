package com.kryptkode.data.charactersearch.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.data.utils.MockDataFactory
import org.junit.Before
import org.junit.Test


class CharacterInfoMapperTest {

    private lateinit var sut : CharacterInfoMapper

    @Before
    fun setup(){
        sut = CharacterInfoMapper()
    }

    @Test
    fun `map from entity maps data`() {
        val mockCharacter = MockDataFactory.makeCharacterInfoEntity()

        val result = sut.mapFromEntity(mockCharacter)

        assertThat(result.name).isEqualTo(mockCharacter.name)
        assertThat(result.url).isEqualTo(mockCharacter.url)
        assertThat(result.birthYear).isEqualTo(mockCharacter.birthYear)
        assertThat(result.height).isEqualTo(mockCharacter.height)
        assertThat(result.homeWorld).isEqualTo(mockCharacter.homeWorld)
        assertThat(result.films).isEqualTo(mockCharacter.films)
        assertThat(result.species).isEqualTo(mockCharacter.species)
    }

    @Test
    fun `map to entity maps data`() {
        val mockCharacter = MockDataFactory.makeDomainCharacterInfo()

        val result = sut.mapToEntity(mockCharacter)

        assertThat(result.name).isEqualTo(mockCharacter.name)
        assertThat(result.url).isEqualTo(mockCharacter.url)
        assertThat(result.birthYear).isEqualTo(mockCharacter.birthYear)
        assertThat(result.height).isEqualTo(mockCharacter.height)
        assertThat(result.homeWorld).isEqualTo(mockCharacter.homeWorld)
        assertThat(result.films).isEqualTo(mockCharacter.films)
        assertThat(result.species).isEqualTo(mockCharacter.species)
    }

}
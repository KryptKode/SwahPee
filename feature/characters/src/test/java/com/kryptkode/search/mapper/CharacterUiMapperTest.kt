package com.kryptkode.search.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.characters.mapper.CharacterUiMapper
import com.kryptkode.characters.utils.UnitsConverter
import com.kryptkode.search.utils.SampleDataFactory
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test


class CharacterUiMapperTest {
    private lateinit var unitConverter:UnitsConverter
    private lateinit var sut: CharacterUiMapper

    @Before
    fun setUp() {
        unitConverter = mockk()
        sut = CharacterUiMapper(unitConverter)
        stubUnitMapper()
    }

    @Test
    fun `map to entity maps data`() {

        val mockCharacter = SampleDataFactory.makeDomainCharacter()

        val result = sut.mapToEntity(mockCharacter)

        assertThat(result.birthYear).isEqualTo(mockCharacter.birthYear)
        assertThat(result.heightCm).isEqualTo(mockCharacter.height)
        assertThat(result.heightInches).isEqualTo(HEIGHT_IN_INCHES)
        assertThat(result.name).isEqualTo(mockCharacter.name)
        assertThat(result.url).isEqualTo(mockCharacter.url)
    }

    @Test
    fun `map to entity calls unit converter`() {

        val mockCharacter = SampleDataFactory.makeDomainCharacter()

        sut.mapToEntity(mockCharacter)

        verify {
            unitConverter.convertCmToInches(mockCharacter.height)
        }
    }

    private fun stubUnitMapper() {
        every {
            unitConverter.convertCmToInches(any())
        } returns HEIGHT_IN_INCHES
    }

    companion object {
        private const val HEIGHT_IN_INCHES = "233"
    }
}
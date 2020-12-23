package com.kryptkode.data.charactersearch.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.data.utils.MockDataFactory.makeDomainSpecie
import com.kryptkode.data.utils.MockDataFactory.makeSpecie
import org.junit.Before
import org.junit.Test


class SpecieMapperTest {
    private lateinit var SUT: SpecieMapper

    @Before
    fun setUp() {
        SUT = SpecieMapper()
    }

    @Test
    fun `map from entity maps data`() {
        val mockSpecie = makeSpecie()

        val result = SUT.mapFromEntity(mockSpecie)

        assertThat(result.homeWorld).isEqualTo(mockSpecie.homeWorld)
        assertThat(result.name).isEqualTo(mockSpecie.name)
        assertThat(result.language).isEqualTo(mockSpecie.language)
    }

    @Test
    fun `map to entity maps data`() {
        val mockSpecie = makeDomainSpecie()

        val result = SUT.mapToEntity(mockSpecie)

        assertThat(result.homeWorld).isEqualTo(mockSpecie.homeWorld)
        assertThat(result.name).isEqualTo(mockSpecie.name)
        assertThat(result.language).isEqualTo(mockSpecie.language)
    }
}
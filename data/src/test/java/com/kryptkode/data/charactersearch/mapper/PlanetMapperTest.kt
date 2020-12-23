package com.kryptkode.data.charactersearch.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.data.utils.MockDataFactory.makeDomainPlanet
import com.kryptkode.data.utils.MockDataFactory.makePlanetEntity
import org.junit.Before
import org.junit.Test


class PlanetMapperTest {
    private lateinit var SUT: PlanetMapper

    @Before
    fun setUp() {
        SUT = PlanetMapper()
    }

    @Test
    fun `map from entity maps data`() {
        val mockPlanet = makePlanetEntity()

        val result = SUT.mapFromEntity(mockPlanet)

        assertThat(result.population).isEqualTo(mockPlanet.population)
        assertThat(result.name).isEqualTo(mockPlanet.name)
    }

    @Test
    fun `map to entity maps data`() {
        val mockPlanet = makeDomainPlanet()

        val result = SUT.mapToEntity(mockPlanet)

        assertThat(result.population).isEqualTo(mockPlanet.population)
        assertThat(result.name).isEqualTo(mockPlanet.name)
    }
}
package com.kryptkode.remote.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.remote.utils.MockDataFactory
import org.junit.Before
import org.junit.Test

class PlanetRemoteMapperTest {
    private lateinit var sut: PlanetRemoteMapper

    @Before
    fun setup(){
        sut = PlanetRemoteMapper()
    }

    @Test
    fun `map to entity maps data`(){

        val testPlanet = MockDataFactory.makePlanetRemote()
        val result = sut.mapToEntity(testPlanet)

        assertThat(result.name).isEqualTo(testPlanet.name)
        assertThat(result.population).isEqualTo(testPlanet.population)
    }
}
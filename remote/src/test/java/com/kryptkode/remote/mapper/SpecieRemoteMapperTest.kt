package com.kryptkode.remote.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.remote.utils.MockDataFactory
import org.junit.Before
import org.junit.Test

class SpecieRemoteMapperTest {
    private lateinit var sut: SpecieRemoteMapper

    @Before
    fun setup(){
        sut = SpecieRemoteMapper()
    }

    @Test
    fun `map to entity maps data`(){

        val testSpecie = MockDataFactory.makeSpecieRemote()
        val result = sut.mapToEntity(testSpecie)

        assertThat(result.homeWorld).isEqualTo(testSpecie.homeWorld)
        assertThat(result.language).isEqualTo(testSpecie.language)
        assertThat(result.name).isEqualTo(testSpecie.name)
    }
}
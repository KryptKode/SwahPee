package com.kryptkode.remote.mapper

import com.google.common.truth.Truth.assertThat
import com.kryptkode.remote.utils.MockDataFactory
import org.junit.Before
import org.junit.Test

class FilmRemoteMapperTest {

    private lateinit var sut: FilmRemoteMapper

    @Before
    fun setup(){
        sut = FilmRemoteMapper()
    }

    @Test
    fun `map to entity maps data`(){

        val testFilmRemote = MockDataFactory.makeFilmRemote()
        val result = sut.mapToEntity(testFilmRemote)

        assertThat(result.openingCrawl).isEqualTo(testFilmRemote.openingCrawl)
        assertThat(result.title).isEqualTo(testFilmRemote.title)
    }
}
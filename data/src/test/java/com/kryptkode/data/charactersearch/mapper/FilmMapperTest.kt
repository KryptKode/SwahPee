package com.kryptkode.data.charactersearch.mapper

import com.google.common.truth.Truth
import com.kryptkode.data.utils.MockDataFactory.makeDomainFilm
import com.kryptkode.data.utils.MockDataFactory.makeFilmEntity
import org.junit.Before
import org.junit.Test

class FilmMapperTest {
    private lateinit var SUT: FilmMapper

    @Before
    fun setUp() {
        SUT = FilmMapper()
    }

    @Test
    fun `map from entity maps data`() {
        val mockFilm = makeFilmEntity()

        val result = SUT.mapFromEntity(mockFilm)

        Truth.assertThat(result.openingCrawl).isEqualTo(mockFilm.openingCrawl)
        Truth.assertThat(result.title).isEqualTo(mockFilm.title)
    }

    @Test
    fun `map to entity maps data`() {
        val mockFilm = makeDomainFilm()

        val result = SUT.mapToEntity(mockFilm)

        Truth.assertThat(result.openingCrawl).isEqualTo(mockFilm.openingCrawl)
        Truth.assertThat(result.title).isEqualTo(mockFilm.title)
    }
}
package com.kryptkode.remote

import com.google.common.truth.Truth.assertThat
import com.kryptkode.remote.api.SwahPeeServiceApi
import com.kryptkode.remote.mapper.FilmRemoteMapper
import com.kryptkode.remote.mapper.PlanetRemoteMapper
import com.kryptkode.remote.mapper.SpecieRemoteMapper
import com.kryptkode.remote.utils.TestSwahPeeServiceApiFactory
import com.kryptkode.remote.utils.mockHttpResponse
import com.kryptkode.testshared.DataFactory.randomString
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.net.HttpURLConnection

class CharacterDetailRemoteImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var swahPeeServiceApi: SwahPeeServiceApi
    private lateinit var searchCharactersRemote: CharacterDetailRemoteImpl
    private lateinit var filmRemoteMapper: FilmRemoteMapper
    private lateinit var planetRemoteMapper: PlanetRemoteMapper
    private lateinit var specieRemoteMapper: SpecieRemoteMapper

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        filmRemoteMapper = FilmRemoteMapper()
        planetRemoteMapper = PlanetRemoteMapper()
        specieRemoteMapper = SpecieRemoteMapper()
        swahPeeServiceApi = TestSwahPeeServiceApiFactory.makeSwahPeeService(mockWebServer)
        searchCharactersRemote = CharacterDetailRemoteImpl(
                swahPeeServiceApi, filmRemoteMapper,
                planetRemoteMapper, specieRemoteMapper)
    }


    @Test
    fun `fetchFilms returns a list result`() = runBlocking {
        stubFilmSuccessResponse()
        val result = searchCharactersRemote.fetchFilms(listOf(randomString()))
        assertThat(result).isInstanceOf(List::class.java)
    }

    @Test
    fun `fetchFilms with non-empty URL returns a non-empty list`() = runBlocking {
        stubFilmSuccessResponse()
        val result = searchCharactersRemote.fetchFilms(listOf(randomString()))
        assertThat(result).isNotEmpty()
    }

    @Test
    fun `fetchFilms with an empty url returns an empty list`() = runBlocking {
        val result = searchCharactersRemote.fetchFilms(emptyList())
        assertThat(result).isEmpty()
    }

    @Test
    fun `fetchPlanet returns a result`() = runBlocking {
        stubPlanetSuccessResponse()
        val result = searchCharactersRemote.fetchPlanet(randomString())
        assertThat(result.population).isEqualTo("5200")
        assertThat(result.name).isEqualTo("Dathomir")
    }

    @Test
    fun `fetchSpecies returns a list result`() = runBlocking {
        stubSpecieSuccessResponse()
        val result = searchCharactersRemote.fetchSpecies(listOf(randomString()))
        assertThat(result).isInstanceOf(List::class.java)
    }

    @Test
    fun `fetchSpecies with non-empty URL returns a non-empty list`() = runBlocking {
        stubSpecieSuccessResponse()
        val result = searchCharactersRemote.fetchSpecies(listOf(randomString()))
        assertThat(result).isNotEmpty()
    }

    @Test
    fun `fetchSpecies with an empty url returns an empty list`() = runBlocking {
        val result = searchCharactersRemote.fetchSpecies(emptyList())
        assertThat(result).isEmpty()
    }

    private fun stubFilmSuccessResponse() {
        mockWebServer.mockHttpResponse("films/film_success.json",
                HttpURLConnection.HTTP_OK)
    }

    private fun stubPlanetSuccessResponse() {
        mockWebServer.mockHttpResponse("planets/planet_success.json",
                HttpURLConnection.HTTP_OK)
    }

    private fun stubSpecieSuccessResponse() {
        mockWebServer.mockHttpResponse("species/species_success.json",
                HttpURLConnection.HTTP_OK)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
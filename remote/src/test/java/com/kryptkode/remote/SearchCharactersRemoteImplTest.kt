package com.kryptkode.remote

import com.google.common.truth.Truth.assertThat
import com.kryptkode.remote.api.SwahPeeServiceApi
import com.kryptkode.remote.mapper.CharacterRemoteMapper
import com.kryptkode.remote.utils.TestSwahPeeServiceApiFactory
import com.kryptkode.remote.utils.mockHttpResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.net.HttpURLConnection

class SearchCharactersRemoteImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var swahPeeServiceApi: SwahPeeServiceApi
    private lateinit var searchCharactersRemote: SearchCharactersRemoteImpl
    private lateinit var mapper: CharacterRemoteMapper

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        mapper = CharacterRemoteMapper()
        swahPeeServiceApi = TestSwahPeeServiceApiFactory.makeSwahPeeService(mockWebServer)
        searchCharactersRemote = SearchCharactersRemoteImpl(swahPeeServiceApi, mapper)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `search characters returns a list result`() = runBlocking {
        stubSuccessResponse()
        val result = searchCharactersRemote.searchCharacters("")
        assertThat(result).isInstanceOf(List::class.java)
    }

    @Test
    fun `search characters with a valid query returns a non-empty list`() = runBlocking {
        stubSuccessResponse()
        val testQuery = "dart"
        val result = searchCharactersRemote.searchCharacters(testQuery)
        assertThat(result).isNotEmpty()
    }

    @Test
    fun `search characters with an invalid query returns an empty list`() = runBlocking {
        stubEmptyResponse()
        val testQuery = "boo yeah?"
        val result = searchCharactersRemote.searchCharacters(testQuery)
        assertThat(result).isEmpty()
    }

    private fun stubSuccessResponse() {
        mockWebServer.mockHttpResponse("search_characters/success.json",
                HttpURLConnection.HTTP_OK)
    }

    private fun stubEmptyResponse() {
        mockWebServer.mockHttpResponse("search_characters/no_results.json",
                HttpURLConnection.HTTP_OK)
    }

}
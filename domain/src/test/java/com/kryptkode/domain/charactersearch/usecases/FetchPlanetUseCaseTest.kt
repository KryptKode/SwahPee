package com.kryptkode.domain.charactersearch.usecases

import com.google.common.truth.Truth.assertThat
import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.dispatchers.AppDispatchers
import com.kryptkode.domain.utils.DataFactory.randomString
import com.kryptkode.domain.utils.MockDataFactory.makePlanet
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class FetchPlanetUseCaseTest {
    private lateinit var dispatchers: AppDispatchers
    private lateinit var repository: CharacterDetailRepository
    private lateinit var SUT: FetchPlanetUseCase

    @Before
    fun setUp() {
        dispatchers = mockk()
        repository = mockk()
        SUT = FetchPlanetUseCase(dispatchers, repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `fetching planet calls repository with passed parameter`() {
        stubDispatchers()
        stubRepo()
        val testUrl = randomString()

        SUT.fetchPlanet(testUrl)

        verify(exactly = 1) {
            repository.fetchPlanet(testUrl)
        }
    }

    @Test
    fun `fetching planet returns data`() = runBlocking {
        stubDispatchers()
        val testPlanet = makePlanet()
        stubRepo(testPlanet)

        val testUrl = randomString()
        val result = SUT.fetchPlanet(testUrl).first()

        assertThat(result).isEqualTo(testPlanet)
    }

    @Test
    fun `fetching planet with empty string returns empty planet`() = runBlocking {
        val result = SUT.fetchPlanet("")
        assertThat(result.first()).isEqualTo(Planet.NO_PLANET)
    }

    @Test
    fun `fetching planet runs on io dispatcher`() {
        stubDispatchers()
        stubRepo()

        val testUrl = randomString()
        SUT.fetchPlanet(testUrl)
        verify(exactly = 1) {
            dispatchers.io
        }
    }

    private fun stubDispatchers() {
        every {
            dispatchers.default
        } returns TestCoroutineDispatcher()

        every {
            dispatchers.io
        } returns TestCoroutineDispatcher()

        every {
            dispatchers.main
        } returns TestCoroutineDispatcher()
    }

    private fun stubRepo(planet: Planet = Planet.NO_PLANET) {
        every {
            repository.fetchPlanet(any())
        } returns flowOf(planet)
    }
}
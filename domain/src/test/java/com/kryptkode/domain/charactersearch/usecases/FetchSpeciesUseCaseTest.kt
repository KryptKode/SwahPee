package com.kryptkode.domain.charactersearch.usecases

import com.google.common.truth.Truth
import com.kryptkode.domain.charactersearch.entities.Specie
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.dispatchers.AppDispatchers
import com.kryptkode.domain.utils.DataFactory.randomString
import com.kryptkode.domain.utils.MockDataFactory.makeSpecie
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
class FetchSpeciesUseCaseTest {

    private lateinit var dispatchers: AppDispatchers
    private lateinit var repository: CharacterDetailRepository
    private lateinit var SUT: FetchSpeciesUseCase

    @Before
    fun setUp() {
        dispatchers = mockk()
        repository = mockk()
        SUT = FetchSpeciesUseCase(dispatchers, repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `fetching species calls repository with passed parameter`() {
        stubDispatchers()
        stubRepo()
        val testUrls = listOf(randomString(), randomString())
        SUT.fetchSpecies(testUrls)
        verify(exactly = 1) {
            repository.fetchSpecies(testUrls)
        }
    }

    @Test
    fun `fetching species returns data`() = runBlocking {
        stubDispatchers()
        val testCharacters = listOf(makeSpecie(), makeSpecie())
        stubRepo(testCharacters)

        val testQuery = listOf(randomString(), randomString())
        val result = SUT.fetchSpecies(testQuery).first()

        Truth.assertThat(result).isEqualTo(testCharacters)
    }

    @Test
    fun `fetching species with empty urls returns empty species list`() = runBlocking {
        val result = SUT.fetchSpecies(emptyList())
        Truth.assertThat(result.first()).isEmpty()
    }

    @Test
    fun `fetching species runs on io dispatcher`() {
        stubDispatchers()
        stubRepo()

        val testUrls = listOf(randomString(), randomString())
        SUT.fetchSpecies(testUrls)
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

    private fun stubRepo(list: List<Specie> = emptyList()) {
        every {
            repository.fetchSpecies(any())
        } returns flowOf(list)
    }
}
package com.kryptkode.domain.charactersearch.usecases

import com.google.common.truth.Truth.assertThat
import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.dispatchers.AppDispatchers
import com.kryptkode.domain.utils.MockDataFactory.makeDomainFilm
import com.kryptkode.testshared.DataFactory.randomString
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
class FetchFilmsUseCaseTest {

    private lateinit var dispatchers: AppDispatchers
    private lateinit var repository: CharacterDetailRepository
    private lateinit var SUT: FetchFilmsUseCase

    @Before
    fun setUp() {
        dispatchers = mockk()
        repository = mockk()
        SUT = FetchFilmsUseCase(dispatchers, repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `fetching films calls repository with passed parameter`() {
        stubDispatchers()
        stubRepo()
        val testQuery = listOf(randomString(), randomString())
        SUT.fetchFilms(testQuery)
        verify(exactly = 1) {
            repository.fetchFilms(testQuery)
        }
    }

    @Test
    fun `fetching films returns data`() = runBlocking {
        stubDispatchers()
        val testCharacters = listOf(makeDomainFilm(), makeDomainFilm())
        stubRepo(testCharacters)

        val testQuery = listOf(randomString(), randomString())
        val result = SUT.fetchFilms(testQuery).first()

        assertThat(result).isEqualTo(testCharacters)
    }

    @Test
    fun `fetching films with empty urls returns empty films list`() = runBlocking {
        val result = SUT.fetchFilms(emptyList())
        assertThat(result.first()).isEmpty()
    }

    @Test
    fun `fetching films runs on io dispatcher`() {
        stubDispatchers()
        stubRepo()

        val testUrls = listOf(randomString(), randomString())
        SUT.fetchFilms(testUrls)
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

    private fun stubRepo(list: List<Film> = emptyList()) {
        every {
            repository.fetchFilms(any())
        } returns flowOf(list)
    }
}
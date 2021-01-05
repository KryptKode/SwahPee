package com.kryptkode.domain.charactersearch.usecases

import com.google.common.truth.Truth.assertThat
import com.kryptkode.domain.charactersearch.entities.CharacterInfo
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.charactersearch.repo.SearchCharactersRepository
import com.kryptkode.domain.dispatchers.AppDispatchers
import com.kryptkode.domain.utils.MockDataFactory.makeDomainCharacterInfo
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
class SearchCharactersUseCaseTest {

    private lateinit var dispatchers: AppDispatchers
    private lateinit var searchCharactersRepository: SearchCharactersRepository
    private lateinit var charactersRepository: CharacterDetailRepository
    private lateinit var sut: SearchCharactersUseCase

    @Before
    fun setup() {
        dispatchers = mockk()
        searchCharactersRepository = mockk()
        charactersRepository = mockk()
        sut =
            SearchCharactersUseCase(dispatchers, charactersRepository, searchCharactersRepository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `searching characters calls repository with passed query`() {
        stubDispatchers()
        stubRepo()
        val testQuery = randomString()
        sut.searchCharacters(testQuery)
        verify(exactly = 1) {
            searchCharactersRepository.searchCharacters(testQuery)
        }
    }

    @Test
    fun `searching characters returns data`() = runBlocking {
        stubDispatchers()
        val testCharacters = listOf(makeDomainCharacterInfo(), makeDomainCharacterInfo())
        stubRepo(testCharacters)

        val testQuery = randomString()
        val result = sut.searchCharacters(testQuery).first()

        assertThat(result).isEqualTo(testCharacters)
    }

    @Test
    fun `searching characters runs on io dispatcher`() {
        stubDispatchers()
        stubRepo()

        val testQuery = randomString()
        sut.searchCharacters(testQuery)
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

    private fun stubRepo(list: List<CharacterInfo> = emptyList()) {
        every {
            searchCharactersRepository.searchCharacters(any())
        } returns flowOf(list)
    }
}
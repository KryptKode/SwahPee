package com.kryptkode.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.kryptkode.characters.mapper.CharacterUiMapper
import com.kryptkode.characters.search.SearchCharactersViewModel
import com.kryptkode.domain.charactersearch.usecases.SearchCharactersUseCase
import com.kryptkode.domain.dispatchers.AppDispatchers
import com.kryptkode.testshared.MainCoroutineRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchCharactersViewModelTest {

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private lateinit var searchCharactersUseCase: SearchCharactersUseCase
    private lateinit var characterUiMapper: CharacterUiMapper
    private lateinit var dispatchers: AppDispatchers
    private lateinit var sut: SearchCharactersViewModel


    @Before
    fun setUp() {
        searchCharactersUseCase = mockk()
        characterUiMapper = mockk()
        dispatchers = mockk()

        stubDispatchers()

        sut = SearchCharactersViewModel(
            searchCharactersUseCase,
            characterUiMapper,
            dispatchers,
        )
    }

    @Test
    fun `showLoading posts loading event`() {

        assertThat(sut.showLoading.value).isNull()

        sut.showLoading()

        assertThat(sut.showLoading.value!!.peekContent()).isEqualTo(Unit)
    }


    @Test
    fun `hideLoading posts loading event`() {

        assertThat(sut.hideLoading.value).isNull()

        sut.hideLoading()

        assertThat(sut.hideLoading.value!!.peekContent()).isEqualTo(Unit)
    }

    @Test
    fun `showError posts error event`() {

        assertThat(sut.showError.value).isNull()

        val testMessage = "Error"

        sut.showError(testMessage)

        assertThat(sut.showError.value!!.peekContent()).isEqualTo(testMessage)
    }


    @Test
    fun `searchCharacters posts query event`() {

        assertThat(sut.searchQuery.value).isNull()

        val testQuery = "dar"

        sut.searchCharacters(testQuery)

        assertThat(sut.searchQuery.value!!).isEqualTo(testQuery)
    }

    @Test
    fun `searchCharacters posts results`() {
        val testQuery = "dar"
        sut.searchCharacters(testQuery)

    }


    @After
    fun tearDown() {
        unmockkAll()
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
}
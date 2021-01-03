package com.kryptkode.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.kryptkode.characters.search.SearchCharactersViewModel
import com.kryptkode.testshared.MainCoroutineRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchCharactersViewModelTest {

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private lateinit var sut: SearchCharactersViewModel


    @Before
    fun setUp() {

    }

    @Test
    fun `showLoading posts loading event`(){

        assertThat(sut.showLoading.value).isNull()

        sut.showLoading()

        assertThat(sut.showLoading.value!!.peekContent()).isEqualTo(Unit)
    }


    @Test
    fun `hideLoading posts loading event`(){

        assertThat(sut.hideLoading.value).isNull()

        sut.hideLoading()

        assertThat(sut.hideLoading.value!!.peekContent()).isEqualTo(Unit)
    }

    @Test
    fun `showError posts error event`(){

        assertThat(sut.showError.value).isNull()

        val testMessage = "Error"

        sut.showError(testMessage)

        assertThat(sut.showError.value!!.peekContent()).isEqualTo(testMessage)
    }


    @Test
    fun `searchCharacters posts query event`(){

        assertThat(sut.searchQuery.value).isNull()

        val testQuery = "dar"

        sut.searchCharacters(testQuery)

        assertThat(sut.searchQuery.value!!).isEqualTo(testQuery)
    }

    @Test
    fun `searchCharacters posts results`(){
        val testQuery = "dar"
        sut.searchCharacters(testQuery)

    }




    @After
    fun tearDown() {
    }
}
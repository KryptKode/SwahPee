package com.kryptkode.domain.charactersearch.usecases

import com.google.common.truth.Truth.assertThat
import com.kryptkode.domain.charactersearch.entities.CharacterInfo
import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.entities.Specie
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.dispatchers.AppDispatchers
import com.kryptkode.domain.utils.MockDataFactory
import com.kryptkode.testshared.DataFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Before
import org.junit.Test


class FetchCharacterInfoUseCaseTest {

    private val testCharacterInfo = MockDataFactory.makeDomainCharacterInfo()

    private lateinit var sut: FetchCharacterInfoUseCase
    private lateinit var repository: CharacterDetailRepositoryTestDouble
    private lateinit var dispatchers: TestDispatchers

    @Before
    fun setup() {
        dispatchers = TestDispatchers()
        repository = CharacterDetailRepositoryTestDouble()
        sut = FetchCharacterInfoUseCase(dispatchers, repository)
    }

    @Test
    fun `fetching character info calls repository with passed parameter`() {
        val testUrl = DataFactory.randomString()
        sut.fetchCharacterInfo(testUrl)
        assertThat(repository.characterUrl).isEqualTo(testUrl)
    }

    @Test
    fun `fetching character info runs on io dispatcher`() = runBlocking {

        val testUrl = DataFactory.randomString()
        sut.fetchCharacterInfo(testUrl)

        assertThat(dispatchers.mainDispatcherCalled).isFalse()
        assertThat(dispatchers.defaultDispatcherCalled).isFalse()
        assertThat(dispatchers.ioDispatcherCalled).isTrue()
    }

    @Test
    fun `fetching character info returns data`() = runBlocking {
        val testUrl = DataFactory.randomString()
        val result = sut.fetchCharacterInfo(testUrl).first()
        assertThat(result).isEqualTo(testCharacterInfo)
    }

    @Test
    fun `fetching character info with empty string returns empty character info`() = runBlocking {
        val result = sut.fetchCharacterInfo("")
        assertThat(result.first()).isEqualTo(CharacterInfo.NO_CHARACTER_INFO)
    }

    class TestDispatchers : AppDispatchers {
        var mainDispatcherCalled = false
        var ioDispatcherCalled = false
        var defaultDispatcherCalled = false

        override val main: CoroutineDispatcher
            get() {
                mainDispatcherCalled = true
                return TestCoroutineDispatcher()
            }

        override val io: CoroutineDispatcher
            get() {
                ioDispatcherCalled = true
                return TestCoroutineDispatcher()
            }

        override val default: CoroutineDispatcher
            get() {
                defaultDispatcherCalled = true
                return TestCoroutineDispatcher()
            }
    }

    inner class CharacterDetailRepositoryTestDouble : CharacterDetailRepository {
        var characterUrl = ""

        override fun fetchFilms(urls: List<String>): Flow<List<Film>> {
            TODO()
        }

        override fun fetchPlanet(planetUrl: String): Flow<Planet> {
           TODO()
        }

        override fun fetchSpecies(urls: List<String>): Flow<List<Specie>> {
            TODO()
        }

        override fun getCharacterInfo(characterUrl: String): Flow<CharacterInfo> {
            this.characterUrl = characterUrl
            return flowOf(testCharacterInfo)
        }

        override suspend fun saveCharacterInfo(characters: List<CharacterInfo>) {
            TODO("Not yet implemented")
        }
    }
}
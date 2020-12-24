package com.kryptkode.data.charactersearch

import com.google.common.truth.Truth.assertThat
import com.kryptkode.data.charactersearch.entities.CharacterEntity
import com.kryptkode.data.charactersearch.mapper.CharacterMapper
import com.kryptkode.data.charactersearch.remote.SearchCharactersRemote
import com.kryptkode.data.utils.MockDataFactory.makeCharacterEntity
import com.kryptkode.domain.charactersearch.entities.Character
import com.kryptkode.testshared.DataFactory.randomString
import io.mockk.*
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test


class SearchCharactersRepositoryImplTest {
    private lateinit var sut: SearchCharactersRepositoryImpl
    private lateinit var mapper: CharacterMapper
    private lateinit var remote: SearchCharactersRemote

    @Before
    fun setup() {
        mapper = mockk()
        remote = mockk()
        sut = SearchCharactersRepositoryImpl(remote, mapper)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `searchCharacters calls remote with correct params`() = runBlocking {
        listOf(makeCharacterEntity(), makeCharacterEntity()).apply {
            stubRemote(this)
            forEach {
                stubMapper(it, Character(it.name, it.birthYear, it.height, it.url))
            }
        }

        val testQuery = randomString()

        sut.searchCharacters(testQuery).single()

        coVerify(exactly = 1) {
            remote.searchCharacters(testQuery)
        }
    }

    @Test
    fun `searchCharacters calls mapper`() = runBlocking {
        val charactersList = listOf(makeCharacterEntity(), makeCharacterEntity()).apply {
            stubRemote(this)
            forEach {
                stubMapper(it, Character(it.name, it.birthYear, it.height, it.url))
            }
        }

        val testQuery = randomString()
        sut.searchCharacters(testQuery).single()

        coVerifyAll {
            charactersList.forEach {
                mapper.mapFromEntity(it)
            }
        }
    }

    @Test
    fun `searchCharacters returns data`() = runBlocking {
        val domainCharacters = mutableListOf<Character>()
        listOf(makeCharacterEntity(), makeCharacterEntity()).apply {
            stubRemote(this)
            forEach {
                val character = Character(it.name, it.birthYear, it.height, it.url)
                domainCharacters.add(character)
                stubMapper(it, character)
            }
        }

        val testQuery = randomString()
        val result = sut.searchCharacters(testQuery).single()

        assertThat(result).isEqualTo(domainCharacters)
    }

    private fun stubRemote(items: List<CharacterEntity>) {
        coEvery {
            remote.searchCharacters(any())
        } returns items
    }

    private fun stubMapper(item: CharacterEntity, domain: Character) {
        coEvery {
            mapper.mapFromEntity(item)
        } returns domain
    }
}
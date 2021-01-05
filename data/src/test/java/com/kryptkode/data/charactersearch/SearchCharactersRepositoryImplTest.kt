package com.kryptkode.data.charactersearch

import com.google.common.truth.Truth.assertThat
import com.kryptkode.data.charactersearch.entities.CharacterInfoEntity
import com.kryptkode.data.charactersearch.mapper.CharacterInfoMapper
import com.kryptkode.data.charactersearch.remote.SearchCharactersRemote
import com.kryptkode.data.utils.MockDataFactory.makeCharacterInfoEntity
import com.kryptkode.domain.charactersearch.entities.CharacterInfo
import com.kryptkode.testshared.DataFactory.randomString
import io.mockk.*
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test


class SearchCharactersRepositoryImplTest {
    private lateinit var sut: SearchCharactersRepositoryImpl
    private lateinit var mapper: CharacterInfoMapper
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
        listOf(makeCharacterInfoEntity(), makeCharacterInfoEntity()).apply {
            stubRemote(this)
            forEach {
                stubMapper(it, CharacterInfo(it.name, it.url, it.birthYear, it.height, it.homeWorld, it.films, it.species))
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
        val charactersList = listOf(makeCharacterInfoEntity(), makeCharacterInfoEntity()).apply {
            stubRemote(this)
            forEach {
                stubMapper(it, CharacterInfo(it.name, it.url, it.birthYear, it.height, it.homeWorld, it.films, it.species))
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
        val domainCharacters = mutableListOf<CharacterInfo>()
        listOf(makeCharacterInfoEntity(), makeCharacterInfoEntity()).apply {
            stubRemote(this)
            forEach {
                val character = CharacterInfo(it.name, it.url, it.birthYear, it.height, it.homeWorld, it.films, it.species)
                domainCharacters.add(character)
                stubMapper(it, character)
            }
        }

        val testQuery = randomString()
        val result = sut.searchCharacters(testQuery).single()

        assertThat(result).isEqualTo(domainCharacters)
    }

    private fun stubRemote(items: List<CharacterInfoEntity>) {
        coEvery {
            remote.searchCharacters(any())
        } returns items
    }

    private fun stubMapper(item: CharacterInfoEntity, domain: CharacterInfo) {
        coEvery {
            mapper.mapFromEntity(item)
        } returns domain
    }
}
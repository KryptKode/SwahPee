package com.kryptkode.data.charactersearch

import com.google.common.truth.Truth.assertThat
import com.kryptkode.data.charactersearch.entities.FilmEntity
import com.kryptkode.data.charactersearch.entities.PlanetEntity
import com.kryptkode.data.charactersearch.entities.SpecieEntity
import com.kryptkode.data.charactersearch.mapper.FilmMapper
import com.kryptkode.data.charactersearch.mapper.PlanetMapper
import com.kryptkode.data.charactersearch.mapper.SpecieMapper
import com.kryptkode.data.charactersearch.remote.CharacterDetailRemote
import com.kryptkode.data.utils.MockDataFactory.makeFilmEntity
import com.kryptkode.data.utils.MockDataFactory.makePlanetEntity
import com.kryptkode.data.utils.MockDataFactory.makeSpecie
import com.kryptkode.domain.charactersearch.entities.Film
import com.kryptkode.domain.charactersearch.entities.Planet
import com.kryptkode.domain.charactersearch.entities.Specie
import com.kryptkode.testshared.DataFactory.randomString
import io.mockk.*
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test


class CharacterDetailRepositoryImplTest {
    private lateinit var sut: CharacterDetailRepositoryImpl
    private lateinit var filmMapper: FilmMapper
    private lateinit var planetMapper: PlanetMapper
    private lateinit var specieMapper: SpecieMapper
    private lateinit var remote: CharacterDetailRemote


    @Before
    fun setup() {
        filmMapper = mockk()
        planetMapper = mockk()
        specieMapper = mockk()
        remote = mockk()
        sut = CharacterDetailRepositoryImpl(remote, filmMapper, planetMapper, specieMapper)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `fetchFilms calls remote with correct params`() = runBlocking {
        listOf(makeFilmEntity(), makeFilmEntity()).apply {
            stubFetchFilmsRemote(this)
            forEach {
                stubFilmMapper(it, Film(it.title, it.openingCrawl))
            }
        }

        val testQuery = listOf(randomString())

        sut.fetchFilms(testQuery).single()

        coVerify(exactly = 1) {
            remote.fetchFilms(testQuery)
        }
    }

    @Test
    fun `fetchFilms calls mapper`() = runBlocking {
        val filmsList = listOf(makeFilmEntity(), makeFilmEntity()).apply {
            stubFetchFilmsRemote(this)
            forEach {
                stubFilmMapper(it, Film(it.title, it.openingCrawl))
            }
        }

        val testQuery = listOf(randomString())
        sut.fetchFilms(testQuery).single()

        coVerifyAll {
            filmsList.forEach {
                filmMapper.mapFromEntity(it)
            }
        }
    }

    @Test
    fun `fetchFilms returns data`() = runBlocking {
        val domainFilms = mutableListOf<Film>()
        listOf(makeFilmEntity(), makeFilmEntity()).apply {
            stubFetchFilmsRemote(this)
            forEach {
                val film = Film(it.title, it.openingCrawl)
                domainFilms.add(film)
                stubFilmMapper(it, film)
            }
        }

        val testQuery = listOf(randomString())
        val result = sut.fetchFilms(testQuery).single()

        assertThat(result).isEqualTo(domainFilms)
    }

    @Test
    fun `fetchPlanet calls remote with correct params`() = runBlocking {
        makePlanetEntity().let {
            stubFetchPlanetRemote(it)
            stubPlanetMapper(it, Planet(it.name, it.population))
        }

        val testQuery = randomString()

        sut.fetchPlanet(testQuery).single()

        coVerify(exactly = 1) {
            remote.fetchPlanet(testQuery)
        }
    }

    @Test
    fun `fetchPlanet calls mapper`() = runBlocking {
        val testPlanet = makePlanetEntity().also {
            stubFetchPlanetRemote(it)
            stubPlanetMapper(it, Planet(it.name, it.population))
        }

        val testQuery = randomString()
        sut.fetchPlanet(testQuery).single()

        coVerifyAll {
            planetMapper.mapFromEntity(testPlanet)
        }
    }

    @Test
    fun `fetchPlanet returns data`() = runBlocking {
        val testPlanet = makePlanetEntity().let {
            stubFetchPlanetRemote(it)
            val planet = Planet(it.name, it.population)
            stubPlanetMapper(it, planet)
            planet
        }

        val testQuery = randomString()
        val result = sut.fetchPlanet(testQuery).single()

        assertThat(result).isEqualTo(testPlanet)
    }

    @Test
    fun `fetchSpecies calls remote with correct params`() = runBlocking {
        listOf(makeSpecie(), makeSpecie()).apply {
            stubFetchSpecieRemote(this)
            forEach {
                stubSpecieMapper(it, Specie(it.name, it.language, it.homeWorld))
            }
        }

        val testQuery = listOf(randomString())

        sut.fetchSpecies(testQuery).single()

        coVerify(exactly = 1) {
            remote.fetchSpecies(testQuery)
        }
    }

    @Test
    fun `fetchSpecies calls mapper`() = runBlocking {
        val filmsList = listOf(makeSpecie(), makeSpecie()).apply {
            stubFetchSpecieRemote(this)
            forEach {
                stubSpecieMapper(it, Specie(it.name, it.language, it.homeWorld))
            }
        }

        val testQuery = listOf(randomString())
        sut.fetchSpecies(testQuery).single()

        coVerifyAll {
            filmsList.forEach {
                specieMapper.mapFromEntity(it)
            }
        }
    }

    @Test
    fun `fetchSpecies returns data`() = runBlocking {
        val domainSpecies = mutableListOf<Specie>()
        listOf(makeSpecie(), makeSpecie()).apply {
            stubFetchSpecieRemote(this)
            forEach {
                val specie = Specie(it.name, it.language, it.homeWorld)
                domainSpecies.add(specie)
                stubSpecieMapper(it, specie)
            }
        }

        val testQuery = listOf(randomString())
        val result = sut.fetchSpecies(testQuery).single()

        assertThat(result).isEqualTo(domainSpecies)
    }

    private fun stubFetchFilmsRemote(items: List<FilmEntity>) {
        coEvery {
            remote.fetchFilms(any())
        } returns items
    }

    private fun stubFilmMapper(item: FilmEntity, domain: Film) {
        coEvery {
            filmMapper.mapFromEntity(item)
        } returns domain
    }

    private fun stubFetchPlanetRemote(entity: PlanetEntity = PlanetEntity.NO_PLANET) {
        coEvery {
            remote.fetchPlanet(any())
        } returns entity
    }

    private fun stubPlanetMapper(item: PlanetEntity, domain: Planet) {
        coEvery {
            planetMapper.mapFromEntity(item)
        } returns domain
    }

    private fun stubFetchSpecieRemote(items: List<SpecieEntity>) {
        coEvery {
            remote.fetchSpecies(any())
        } returns items
    }

    private fun stubSpecieMapper(item: SpecieEntity, domain: Specie) {
        coEvery {
            specieMapper.mapFromEntity(item)
        } returns domain
    }
}
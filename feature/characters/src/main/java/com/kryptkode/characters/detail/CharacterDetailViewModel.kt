package com.kryptkode.characters.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.kryptkode.characters.DataState
import com.kryptkode.characters.entities.CharacterUi
import com.kryptkode.characters.entities.FilmUi
import com.kryptkode.characters.entities.PlanetUi
import com.kryptkode.characters.entities.SpeciesUi
import com.kryptkode.characters.mapper.CharacterInfoUiMapper
import com.kryptkode.characters.mapper.FilmUiMapper
import com.kryptkode.characters.mapper.PlanetUiMapper
import com.kryptkode.characters.mapper.SpecieUiMapper
import com.kryptkode.commonandroid.livedata.extension.switchMap
import com.kryptkode.domain.charactersearch.usecases.FetchCharacterInfoUseCase
import com.kryptkode.domain.charactersearch.usecases.FetchFilmsUseCase
import com.kryptkode.domain.charactersearch.usecases.FetchPlanetUseCase
import com.kryptkode.domain.charactersearch.usecases.FetchSpeciesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import timber.log.Timber

class CharacterDetailViewModel @ViewModelInject constructor(
        private val fetchCharacterInfoUseCase: FetchCharacterInfoUseCase,
        private val fetchSpeciesUseCase: FetchSpeciesUseCase,
        private val fetchPlanetUseCase: FetchPlanetUseCase,
        private val fetchFilmsUseCase: FetchFilmsUseCase,
        private val characterUiMapper: CharacterInfoUiMapper,
        private val specieUiMapper: SpecieUiMapper,
        private val planetUiMapper: PlanetUiMapper,
        private val filmUiMapper: FilmUiMapper
) : ViewModel() {

    private val characterUrl = MutableLiveData<String>()
    private val loadPlanet = MediatorLiveData<String>()
    private val loadFilms = MediatorLiveData<List<String>>()
    private val loadSpecies = MediatorLiveData<List<String>>()

    private val characterInfo = characterUrl.switchMap { fetchCharacterInfoUseCase.fetchCharacterInfo(it).asLiveData() }.apply {
        loadPlanet.addSource(this){
            loadPlanet.value = it.homeWorld
        }
        loadFilms.addSource(this){
            loadFilms.value = it.films
        }

        loadSpecies.addSource(this){
            loadSpecies.value = it.species
        }
    }

    val character = characterInfo.map { characterUiMapper.mapToEntity(it) }

    val films: LiveData<DataState<List<FilmUi>>> = loadFilms.switchMap {
        fetchFilmsUseCase.fetchFilms(it)
                .map { films ->
                    val result = films.map { filmUiMapper.mapToEntity(it) }
                    DataState.Success(result) as DataState<List<FilmUi>>
                }
                .onStart { emit(DataState.Loading) }
                .catch {
                    Timber.e("Error occurred while finding characters: $it")
                    emit(DataState.Error(it.localizedMessage))
                }
                .asLiveData()
    }

    val species: LiveData<DataState<List<SpeciesUi>>> = loadSpecies.switchMap {
        fetchSpeciesUseCase.fetchSpecies(it)
                .map { species ->
                    val result = species.map { specieUiMapper.mapToEntity(it) }
                    DataState.Success(result) as DataState<List<SpeciesUi>>
                }
                .onStart { emit(DataState.Loading) }
                .catch {
                    Timber.e("Error occurred while finding characters: $it")
                    emit(DataState.Error(it.localizedMessage))
                }
                .asLiveData()
    }

    val planet: LiveData<DataState<PlanetUi>> = loadPlanet.switchMap {
        fetchPlanetUseCase.fetchPlanet(it)
                .map {
                    val result = planetUiMapper.mapToEntity(it)
                    DataState.Success(result) as DataState<PlanetUi>
                }
                .onStart { emit(DataState.Loading) }
                .catch {
                    Timber.e("Error occurred while finding characters: $it")
                    emit(DataState.Error(it.localizedMessage))
                }
                .asLiveData()
    }

    fun getCharacterDetails(character: CharacterUi) {
        characterUrl.postValue(character.url)
    }

    fun loadPlanet() {
        characterInfo.value!!.let {
            loadPlanet.postValue(it.homeWorld)
        }
    }

    fun loadFilms() {
        characterInfo.value!!.let {
            loadFilms.postValue(it.films)
        }
    }

    fun loadSpecies() {
        characterInfo.value!!.let {
            loadSpecies.postValue(it.species)
        }
    }
}
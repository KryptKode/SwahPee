package com.kryptkode.characters.search

import androidx.annotation.VisibleForTesting
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.kryptkode.characters.mapper.CharacterUiDomainMapper
import com.kryptkode.commonandroid.livedata.event.Event
import com.kryptkode.commonandroid.livedata.extension.asLiveData
import com.kryptkode.commonandroid.logger.Logger
import com.kryptkode.domain.charactersearch.usecases.SearchCharactersUseCase
import com.kryptkode.domain.dispatchers.AppDispatchers
import kotlinx.coroutines.flow.*

class SearchCharactersViewModel @ViewModelInject constructor(
    private val searchCharactersUseCase: SearchCharactersUseCase,
    private val mapper: CharacterUiDomainMapper,
    dispatchers: AppDispatchers,
    private val logger: Logger,
) : ViewModel() {

    private val mutableShowLoading = MutableLiveData<Event<Unit>>()
    val showLoading = mutableShowLoading.asLiveData()

    private val mutableHideLoading = MutableLiveData<Event<Unit>>()
    val hideLoading = mutableHideLoading.asLiveData()

    private val mutableShowError = MutableLiveData<Event<String>>()
    val showError = mutableShowError.asLiveData()

    @VisibleForTesting
    val searchQuery = MutableLiveData<String>()
    val characters = searchQuery.asFlow()
            .debounce(500)
            .filter { it.trim().isNotEmpty() }
            .distinctUntilChanged()
            .onEach {
                logger.w("Starting search flow: ${Thread.currentThread().name}")
                showLoading()
            }
            .flatMapLatest { searchCharactersUseCase.searchCharacters(it) }
            .map { it.map { item -> mapper.mapToEntity(item) } }
            .onEach {
                logger.w("Search flow completed ${Thread.currentThread().name}")
                hideLoading()
                if (it.isEmpty()) {
                    showError("No characters found for your query ${Thread.currentThread().name}")
                }
            }
            .flowOn(dispatchers.io)
            .catch {
                logger.e("Error occurred while finding characters: $it")
                showError(it.localizedMessage ?: "An error  occurred")
            }
            .asLiveData()


    fun searchCharacters(query: String) {
        logger.d("Finding characters: $query")
        searchQuery.value = query
    }

    @VisibleForTesting
    fun showLoading() {
        mutableShowLoading.postValue(Event(Unit))
    }

    @VisibleForTesting
    fun hideLoading() {
        mutableHideLoading.postValue(Event(Unit))
    }

    @VisibleForTesting
    fun showError(message: String) {
        mutableShowError.postValue(Event(message))
    }
}
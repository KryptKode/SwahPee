package com.kryptkode.charactersearch

import androidx.annotation.VisibleForTesting
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kryptkode.commonandroid.livedata.event.Event
import com.kryptkode.commonandroid.livedata.extension.asLiveData
import com.kryptkode.domain.charactersearch.usecases.SearchCharactersUseCase
import kotlinx.coroutines.flow.*

class SearchCharactersViewModel @ViewModelInject constructor(
        private val searchCharactersUseCase: SearchCharactersUseCase
) : ViewModel() {

    private val mutableShowLoading = MutableLiveData<Event<Unit>>()
    val showLoading = mutableShowLoading.asLiveData()

    private val mutableHideLoading = MutableLiveData<Event<Unit>>()
    val hideLoading = mutableHideLoading.asLiveData()

    private val mutableShowError = MutableLiveData<Event<String>>()
    val showError = mutableShowError.asLiveData()

    private val searchQuery = MutableStateFlow("")
    val characters = searchQuery.debounce(500)
            .flatMapConcat { searchCharactersUseCase.searchCharacters(it) }
            .onStart { showLoading() }
            .onCompletion { hideLoading() }
            .catch { showError(it.localizedMessage ?: "An error  occurred")}
            .asLiveData()


    fun searchCharacters(query: String) {
        searchQuery.value = query
    }

    @VisibleForTesting
    fun showLoading() {
        mutableShowLoading.postValue(Event(Unit))
    }

    @VisibleForTesting
    fun hideLoading() {
        mutableShowLoading.postValue(Event(Unit))
    }

    @VisibleForTesting
    fun showError(message: String) {
        mutableShowError.postValue(Event(message))
    }
}
package com.kryptkode.charactersearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kryptkode.charactersearch.view.SearchCharacterViewFactory
import com.kryptkode.charactersearch.view.listview.CharacterListView
import com.kryptkode.commonandroid.ToastHelper
import com.kryptkode.commonandroid.livedata.extension.observeEvent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchCharactersFragment : Fragment(), CharacterListView.Listener {

    @Inject
    lateinit var toastHelper: ToastHelper

    @Inject
    lateinit var viewFactory: SearchCharacterViewFactory

    @Inject
    lateinit var navigator: SearchCharacterNavigator

    private lateinit var searchView: CharacterListView

    private val viewModel: SearchCharactersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchView = viewFactory.getCharacterListView(container)
        setupObservers()
        return searchView.rootView
    }

    override fun onStart() {
        super.onStart()
        searchView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        searchView.unregisterListener(this)
    }

    private fun setupObservers() {
        viewModel.characters.observe(viewLifecycleOwner) {
            searchView.bindCharacters(it)
        }

        viewModel.showError.observeEvent(viewLifecycleOwner) {
            toastHelper.showMessage(it)
        }

        viewModel.showLoading.observeEvent(viewLifecycleOwner) {
            searchView.showLoading()
        }

        viewModel.hideLoading.observeEvent(viewLifecycleOwner) {
            searchView.hideLoading()
        }
    }

    override fun onItemClick(item: UiCharacter) {
        navigator.toCharacterDetail()
    }

    override fun onSearchCharacter(query: String) {
        viewModel.searchCharacters(query)
    }
}
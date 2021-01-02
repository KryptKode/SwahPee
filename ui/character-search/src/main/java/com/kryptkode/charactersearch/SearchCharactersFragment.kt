package com.kryptkode.charactersearch

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kryptkode.charactersearch.databinding.FragmentSearchCharactersBinding
import com.kryptkode.commonandroid.ToastHelper
import com.kryptkode.commonandroid.extension.beGone
import com.kryptkode.commonandroid.extension.beVisible
import com.kryptkode.commonandroid.livedata.extension.observeEvent
import com.kryptkode.commonandroid.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchCharactersFragment : Fragment(R.layout.fragment_search_characters) {

    @Inject
    lateinit var toastHelper: ToastHelper

    private val binding by viewBinding(FragmentSearchCharactersBinding::bind)

    private val viewModel: SearchCharactersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.characters.observe(viewLifecycleOwner){

        }

        viewModel.showError.observeEvent(viewLifecycleOwner){
            toastHelper.showMessage(it)
        }

        viewModel.showLoading.observeEvent(viewLifecycleOwner){
            showLoading()
        }

        viewModel.hideLoading.observeEvent(viewLifecycleOwner){
            hideLoading()
        }
    }

    private fun setupViews() {

        binding.searchEditText.addTextChangedListener {
            viewModel.searchCharacters(it.toString())
        }

        binding.searchResultsRecyclerView.setEmptyView(binding.searchHintGroup)
    }


    private fun showLoading(){
        binding.loadingGroup.beVisible()
    }

    private fun hideLoading(){
        binding.loadingGroup.beGone()
    }
}
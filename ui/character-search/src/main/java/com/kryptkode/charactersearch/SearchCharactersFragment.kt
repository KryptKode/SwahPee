package com.kryptkode.charactersearch

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.kryptkode.charactersearch.databinding.FragmentSearchCharactersBinding
import com.kryptkode.commonandroid.extension.beGone
import com.kryptkode.commonandroid.extension.beVisible
import com.kryptkode.commonandroid.viewbinding.viewBinding

class SearchCharactersFragment : Fragment(R.layout.fragment_search_characters) {

    private val binding by viewBinding(FragmentSearchCharactersBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {

        binding.searchEditText.addTextChangedListener {

        }

        binding.searchResultsRecyclerView.setEmptyView(binding.searchHintGroup)
    }


    fun showLoading(){
        binding.loadingGroup.beVisible()
    }

    fun hideLoading(){
        binding.loadingGroup.beGone()
    }



}
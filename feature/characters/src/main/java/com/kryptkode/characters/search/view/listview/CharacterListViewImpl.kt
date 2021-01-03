package com.kryptkode.characters.search.view.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.kryptkode.characters.CharacterUi
import com.kryptkode.characters.search.view.SearchCharacterViewFactory
import com.kryptkode.commonandroid.extension.beGone
import com.kryptkode.commonandroid.extension.beVisible
import com.kryptkode.search.databinding.LayoutSearchCharactersBinding

class CharacterListViewImpl(
    viewFactory: SearchCharacterViewFactory,
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : CharacterListView() {

    private val binding = LayoutSearchCharactersBinding.inflate(layoutInflater, parent, false)

    private val adapter = CharacterListAdapter(viewFactory) { item ->
        onEachListener {
            it.onItemClick(item)
        }
    }

    init {

        binding.searchEditText.addTextChangedListener { query ->
            onEachListener {
                it.onSearchCharacter(query.toString())
            }
        }

        binding.searchResultsRecyclerView.adapter = adapter
        binding.searchResultsRecyclerView.setEmptyView(binding.searchHintGroup)
    }

    override fun bindCharacters(farms: List<CharacterUi>) {
        adapter.submitList(farms)
    }

    override fun hideLoading() {
        binding.loadingGroup.beGone()
    }

    override fun showLoading() {
        binding.loadingGroup.beVisible()
        binding.searchHintGroup.beGone()
    }

    override val rootView: View
        get() = binding.root
}
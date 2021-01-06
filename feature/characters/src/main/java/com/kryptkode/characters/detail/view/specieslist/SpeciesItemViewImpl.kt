package com.kryptkode.characters.detail.view.specieslist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kryptkode.characters.entities.SpeciesUi
import com.kryptkode.search.R
import com.kryptkode.search.databinding.ItemSpeciesBinding

@SuppressLint("DefaultLocale")
class SpeciesItemViewImpl (
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : SpeciesItemView() {

    private val binding = ItemSpeciesBinding.inflate(layoutInflater, parent, false)

    override fun bind(item: SpeciesUi) {
        binding.nameTextView.text = item.name.capitalize()
        binding.languageTextView.text = getString(R.string.language_label, item.language)
    }

    override val rootView: View
        get() = binding.root
}
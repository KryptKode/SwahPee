package com.kryptkode.characters.detail.view.filmlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kryptkode.characters.entities.FilmUi
import com.kryptkode.search.databinding.ItemFilmBinding

@SuppressLint("DefaultLocale")
class FilmItemViewImpl (
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : FilmItemView() {

    private val binding = ItemFilmBinding.inflate(layoutInflater, parent, false)

    override fun bind(item: FilmUi) {
        binding.nameTextView.text = item.title.capitalize()
        binding.descriptionTextView.text = item.openingCrawl
    }

    override val rootView: View
        get() = binding.root
}
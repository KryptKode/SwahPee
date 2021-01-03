package com.kryptkode.characters.detail.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kryptkode.characters.detail.view.filmlist.FilmItemView
import com.kryptkode.characters.detail.view.filmlist.FilmItemViewImpl
import javax.inject.Inject

class CharacterDetailViewFactory @Inject constructor(
    private val layoutInflater: LayoutInflater
) {

    fun getFilmItemView(parent: ViewGroup? = null): FilmItemView {
        return FilmItemViewImpl(
            layoutInflater,
            parent
        )
    }

    fun getCharacterDetailView(parent: ViewGroup? = null): CharacterDetailView {
        return CharacterDetailViewImpl(
            this,
            layoutInflater,
            parent
        )
    }
}
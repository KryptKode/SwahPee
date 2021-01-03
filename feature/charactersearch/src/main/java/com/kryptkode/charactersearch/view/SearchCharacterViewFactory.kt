package com.kryptkode.charactersearch.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kryptkode.charactersearch.view.itemview.CharacterItemView
import com.kryptkode.charactersearch.view.itemview.CharacterItemViewImpl
import com.kryptkode.charactersearch.view.listview.CharacterListView
import com.kryptkode.charactersearch.view.listview.CharacterListViewImpl
import javax.inject.Inject

class SearchCharacterViewFactory @Inject constructor(private val layoutInflater: LayoutInflater) {

    fun getCharacterItemView(parent: ViewGroup? = null): CharacterItemView {
        return CharacterItemViewImpl(
            layoutInflater,
            parent
        )
    }

    fun getCharacterListView(parent: ViewGroup? = null): CharacterListView {
        return CharacterListViewImpl(
            this,
            layoutInflater,
            parent
        )
    }
}
package com.kryptkode.charactersearch.view.listview

import com.kryptkode.charactersearch.UiCharacter
import com.kryptkode.commonandroid.view.BaseObservableAppView

abstract class CharacterListView: BaseObservableAppView<CharacterListView.Listener>() {
    interface  Listener {
        fun onItemClick(item: UiCharacter)
        fun onSearchCharacter(query:String)
    }

    abstract fun bindCharacters(farms:List<UiCharacter>)
    abstract fun showLoading()
    abstract fun hideLoading()
}
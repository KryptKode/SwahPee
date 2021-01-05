package com.kryptkode.characters.search.view.listview

import com.kryptkode.characters.entities.CharacterUi
import com.kryptkode.commonandroid.view.BaseObservableAppView

abstract class CharacterListView: BaseObservableAppView<CharacterListView.Listener>() {
    interface  Listener {
        fun onItemClick(item: CharacterUi)
        fun onSearchCharacter(query:String)
    }

    abstract fun bindCharacters(farms:List<CharacterUi>)
    abstract fun showLoading()
    abstract fun hideLoading()
}
package com.kryptkode.characters.search.view.itemview

import com.kryptkode.characters.CharacterUi
import com.kryptkode.commonandroid.view.BaseObservableAppView

abstract class CharacterItemView: BaseObservableAppView<CharacterItemView.Listener>() {
    interface Listener{
        fun onFarmClick(item: CharacterUi)
    }

    abstract fun bind(item: CharacterUi)
}
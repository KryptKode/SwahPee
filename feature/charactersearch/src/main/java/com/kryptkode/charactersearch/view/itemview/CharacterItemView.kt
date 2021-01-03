package com.kryptkode.charactersearch.view.itemview

import com.kryptkode.charactersearch.UiCharacter
import com.kryptkode.commonandroid.view.BaseObservableAppView

abstract class CharacterItemView: BaseObservableAppView<CharacterItemView.Listener>() {
    interface Listener{
        fun onFarmClick(item:UiCharacter)
    }

    abstract fun bind(item:UiCharacter)
}
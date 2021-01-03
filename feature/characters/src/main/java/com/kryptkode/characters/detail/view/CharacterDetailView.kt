package com.kryptkode.characters.detail.view

import com.kryptkode.characters.CharacterUi
import com.kryptkode.commonandroid.view.BaseObservableAppView

abstract class CharacterDetailView : BaseObservableAppView<CharacterDetailView.Listener>(){

    interface Listener{
        fun onBackClick()
    }

    abstract fun bindCharacter(character:CharacterUi)
    
}
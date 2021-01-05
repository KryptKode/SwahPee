package com.kryptkode.characters

import com.kryptkode.characters.entities.CharacterUi

interface CharactersNavigator {
    fun toCharacterDetail(character: CharacterUi)
    fun navigateUp()
}
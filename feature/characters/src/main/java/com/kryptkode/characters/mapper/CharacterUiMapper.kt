package com.kryptkode.characters.mapper

import com.kryptkode.characters.entities.CharacterUi
import com.kryptkode.characters.utils.UnitsConverter
import com.kryptkode.domain.charactersearch.entities.Character
import javax.inject.Inject

class CharacterUiMapper @Inject constructor(private val unitsConverter: UnitsConverter) : EntityMapper<CharacterUi, Character> {

    override fun mapToEntity(entity: Character): CharacterUi {
        return CharacterUi(
            entity.name,
            entity.birthYear,
            entity.height,
            unitsConverter.convertCmToInches(entity.height),
            entity.url
        )
    }
}
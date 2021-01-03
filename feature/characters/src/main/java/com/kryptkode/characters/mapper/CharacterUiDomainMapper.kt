package com.kryptkode.characters.mapper

import com.kryptkode.characters.CharacterUi
import com.kryptkode.characters.utils.UnitsConverter
import com.kryptkode.commonandroid.EntityMapper
import com.kryptkode.domain.charactersearch.entities.Character
import javax.inject.Inject

class CharacterUiDomainMapper @Inject constructor() : EntityMapper<CharacterUi, Character> {

    override fun mapFromEntity(entity: CharacterUi): Character {
        return Character(
            entity.name,
            entity.birthYear,
            entity.heightCm,
            entity.url
        )
    }

    override fun mapToEntity(entity: Character): CharacterUi {
        return CharacterUi(
            entity.name,
            entity.birthYear,
            entity.height,
            UnitsConverter.convertCmToInches(entity.height),
            entity.url
        )
    }
}
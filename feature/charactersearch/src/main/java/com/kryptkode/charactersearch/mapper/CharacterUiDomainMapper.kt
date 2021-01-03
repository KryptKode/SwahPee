package com.kryptkode.charactersearch.mapper

import com.kryptkode.charactersearch.UiCharacter
import com.kryptkode.commonandroid.EntityMapper
import com.kryptkode.domain.charactersearch.entities.Character
import javax.inject.Inject

class CharacterUiDomainMapper @Inject constructor() : EntityMapper<UiCharacter, Character> {

    override fun mapFromEntity(entity: UiCharacter): Character {
        return Character(
            entity.name,
            entity.birthYear,
            entity.height,
            entity.url
        )
    }

    override fun mapToEntity(entity: Character): UiCharacter {
        return UiCharacter(
            entity.name,
            entity.birthYear,
            entity.height,
            entity.url
        )
    }
}
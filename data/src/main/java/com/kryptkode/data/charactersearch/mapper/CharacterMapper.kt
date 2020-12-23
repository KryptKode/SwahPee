package com.kryptkode.data.charactersearch.mapper

import com.kryptkode.data.charactersearch.entities.CharacterEntity
import com.kryptkode.domain.charactersearch.entities.Character
import javax.inject.Inject

class CharacterMapper @Inject constructor() : DomainEntityMapper<CharacterEntity, Character> {

    override fun mapFromEntity(entity: CharacterEntity): Character {
        return Character(
            entity.name,
            entity.birthYear,
            entity.height,
            entity.url
        )
    }

    override fun mapToEntity(entity: Character): CharacterEntity {
        return CharacterEntity(
            entity.name,
            entity.birthYear,
            entity.height,
            entity.url
        )
    }
}
package com.kryptkode.cache.mapper

import com.kryptkode.cache.character.DbCharacter
import com.kryptkode.data.charactersearch.entities.CharacterInfoEntity
import javax.inject.Inject

class DbCharacterMapper @Inject constructor() : EntityMapper<DbCharacter, CharacterInfoEntity> {

    override fun mapFromEntity(entity: DbCharacter): CharacterInfoEntity {
        return CharacterInfoEntity(
            entity.name,
            entity.url,
            entity.birthYear,
            entity.height,
            entity.homeWorld,
            entity.films,
            entity.species
        )
    }

    override fun mapToEntity(entity: CharacterInfoEntity): DbCharacter {
        return DbCharacter(
            entity.url,
            entity.name,
            entity.birthYear,
            entity.height,
            entity.homeWorld,
            entity.films,
            entity.species
        )
    }

}
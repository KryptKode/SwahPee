package com.kryptkode.data.charactersearch.mapper

import com.kryptkode.data.charactersearch.entities.CharacterInfoEntity
import com.kryptkode.domain.charactersearch.entities.CharacterInfo
import javax.inject.Inject

class CharacterInfoMapper @Inject constructor() :
    DomainEntityMapper<CharacterInfoEntity, CharacterInfo> {

    override fun mapFromEntity(entity: CharacterInfoEntity): CharacterInfo {
        return CharacterInfo(
            entity.name,
            entity.url,
            entity.birthYear,
            entity.height,
            entity.homeWorld,
            entity.films,
            entity.species
        )
    }

    override fun mapToEntity(entity: CharacterInfo): CharacterInfoEntity {
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
}
package com.kryptkode.data.charactersearch.mapper

import com.kryptkode.data.charactersearch.entities.SpecieEntity
import com.kryptkode.domain.charactersearch.entities.Specie

class SpecieMapper : DomainEntityMapper<SpecieEntity, Specie> {

    override fun mapFromEntity(entity: SpecieEntity): Specie {
        return Specie(
            entity.name,
            entity.language,
            entity.homeWorld
        )
    }

    override fun mapToEntity(entity: Specie): SpecieEntity {
        return SpecieEntity(
            entity.name,
            entity.language,
            entity.homeWorld
        )
    }
}
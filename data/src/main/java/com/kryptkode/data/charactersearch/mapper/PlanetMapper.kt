package com.kryptkode.data.charactersearch.mapper

import com.kryptkode.data.charactersearch.entities.PlanetEntity
import com.kryptkode.domain.charactersearch.entities.Planet
import javax.inject.Inject

class PlanetMapper @Inject constructor() : DomainEntityMapper<PlanetEntity, Planet> {

    override fun mapFromEntity(entity: PlanetEntity): Planet {
        return Planet(
            entity.name,
            entity.population,
        )
    }

    override fun mapToEntity(entity: Planet): PlanetEntity {
        return PlanetEntity(
            entity.name,
            entity.population,
        )
    }
}
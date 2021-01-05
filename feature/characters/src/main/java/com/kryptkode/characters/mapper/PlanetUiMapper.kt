package com.kryptkode.characters.mapper

import com.kryptkode.characters.entities.PlanetUi
import com.kryptkode.domain.charactersearch.entities.Planet
import javax.inject.Inject

class PlanetUiMapper @Inject constructor() : EntityMapper<PlanetUi, Planet> {
    override fun mapToEntity(entity: Planet): PlanetUi {
        return PlanetUi(entity.name, entity.population)
    }
}
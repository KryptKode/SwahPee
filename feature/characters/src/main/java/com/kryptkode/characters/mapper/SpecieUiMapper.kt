package com.kryptkode.characters.mapper

import com.kryptkode.characters.entities.SpeciesUi
import com.kryptkode.domain.charactersearch.entities.Specie
import javax.inject.Inject

class SpecieUiMapper @Inject constructor() : EntityMapper<SpeciesUi, Specie> {
    override fun mapToEntity(entity: Specie): SpeciesUi {
        return SpeciesUi(entity.name, entity.language)
    }
}
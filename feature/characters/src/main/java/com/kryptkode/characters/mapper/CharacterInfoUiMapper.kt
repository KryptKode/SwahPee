package com.kryptkode.characters.mapper

import com.kryptkode.characters.entities.CharacterUi
import com.kryptkode.characters.utils.UnitsConverter
import com.kryptkode.domain.charactersearch.entities.CharacterInfo
import javax.inject.Inject

class CharacterInfoUiMapper @Inject constructor(private val unitsConverter: UnitsConverter) : EntityMapper<CharacterUi, CharacterInfo> {

    override fun mapToEntity(entity: CharacterInfo): CharacterUi {
        return CharacterUi(
            entity.name,
            entity.birthYear,
            entity.height,
            unitsConverter.convertCmToInches(entity.height),
            entity.url
        )
    }
}
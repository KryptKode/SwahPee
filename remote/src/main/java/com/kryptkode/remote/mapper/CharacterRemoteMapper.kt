package com.kryptkode.remote.mapper

import com.kryptkode.data.charactersearch.entities.CharacterInfoEntity
import com.kryptkode.remote.entities.character.CharacterRemote
import javax.inject.Inject

class CharacterRemoteMapper @Inject constructor() : DataEntityMapper<CharacterRemote, CharacterInfoEntity> {

    override fun mapToEntity(remote: CharacterRemote): CharacterInfoEntity {
        return CharacterInfoEntity(
            remote.name,
            remote.url,
            remote.birthYear,
            remote.height,
            remote.homeWorld,
            remote.films,
            remote.species
        )
    }
}
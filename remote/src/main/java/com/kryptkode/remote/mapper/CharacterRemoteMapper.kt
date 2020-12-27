package com.kryptkode.remote.mapper

import com.kryptkode.data.charactersearch.entities.CharacterEntity
import com.kryptkode.remote.entities.character.CharacterRemote
import javax.inject.Inject

class CharacterRemoteMapper @Inject constructor() : DataEntityMapper<CharacterRemote, CharacterEntity> {

    override fun mapToEntity(remote: CharacterRemote): CharacterEntity {
        return CharacterEntity(
            remote.name,
            remote.birthYear,
            remote.height,
            remote.url
        )
    }
}
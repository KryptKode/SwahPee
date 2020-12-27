package com.kryptkode.remote.mapper

import com.kryptkode.data.charactersearch.entities.SpecieEntity
import com.kryptkode.remote.entities.specie.SpecieRemote
import javax.inject.Inject

class SpecieRemoteMapper @Inject constructor() : DataEntityMapper<SpecieRemote, SpecieEntity> {

    override fun mapToEntity(remote: SpecieRemote): SpecieEntity {
        return SpecieEntity(
            remote.name,
            remote.language,
            remote.homeWorld
        )
    }
}
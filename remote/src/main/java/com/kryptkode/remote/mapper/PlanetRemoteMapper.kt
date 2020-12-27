package com.kryptkode.remote.mapper

import com.kryptkode.data.charactersearch.entities.PlanetEntity
import com.kryptkode.remote.entities.planet.PlanetRemote
import javax.inject.Inject

class PlanetRemoteMapper @Inject constructor() : DataEntityMapper<PlanetRemote, PlanetEntity> {

    override fun mapToEntity(remote: PlanetRemote): PlanetEntity {
        return PlanetEntity(
            remote.name,
            remote.population,
        )
    }
}
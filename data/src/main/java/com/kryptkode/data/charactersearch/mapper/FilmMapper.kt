package com.kryptkode.data.charactersearch.mapper

import com.kryptkode.data.charactersearch.entities.FilmEntity
import com.kryptkode.domain.charactersearch.entities.Film
import javax.inject.Inject

class FilmMapper @Inject constructor() : DomainEntityMapper<FilmEntity, Film> {

    override fun mapFromEntity(entity: FilmEntity): Film {
        return Film(
            entity.title,
            entity.openingCrawl,
        )
    }

    override fun mapToEntity(entity: Film): FilmEntity {
        return FilmEntity(
            entity.title,
            entity.openingCrawl,
        )
    }
}
package com.kryptkode.remote.mapper

import com.kryptkode.data.charactersearch.entities.FilmEntity
import com.kryptkode.remote.entities.film.FilmRemote
import javax.inject.Inject

class FilmRemoteMapper @Inject constructor() : DataEntityMapper<FilmRemote, FilmEntity> {

    override fun mapToEntity(remote: FilmRemote): FilmEntity {
        return FilmEntity(
            remote.title,
            remote.openingCrawl,
        )
    }
}
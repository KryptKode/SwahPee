package com.kryptkode.characters.mapper

import com.kryptkode.characters.entities.FilmUi
import com.kryptkode.domain.charactersearch.entities.Film
import javax.inject.Inject

class FilmUiMapper @Inject constructor() : EntityMapper<FilmUi, Film> {
    override fun mapToEntity(entity: Film): FilmUi {
        return FilmUi(entity.title, entity.openingCrawl)
    }
}
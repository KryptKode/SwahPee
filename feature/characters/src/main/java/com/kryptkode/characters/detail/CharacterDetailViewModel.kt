package com.kryptkode.characters.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.kryptkode.characters.mapper.FilmUiMapper
import com.kryptkode.characters.mapper.PlanetUiMapper
import com.kryptkode.characters.mapper.SpecieUiMapper
import com.kryptkode.domain.charactersearch.usecases.FetchFilmsUseCase
import com.kryptkode.domain.charactersearch.usecases.FetchPlanetUseCase
import com.kryptkode.domain.charactersearch.usecases.FetchSpeciesUseCase

class CharacterDetailViewModel @ViewModelInject constructor(
    private val fetchSpeciesUseCase: FetchSpeciesUseCase,
    private val fetchPlanetUseCase: FetchPlanetUseCase,
    private val fetchFilmsUseCase: FetchFilmsUseCase,
    private val specieUiMapper: SpecieUiMapper,
    private val planetUiMapper: PlanetUiMapper,
    private val filmUiMapper: FilmUiMapper
): ViewModel() {


}
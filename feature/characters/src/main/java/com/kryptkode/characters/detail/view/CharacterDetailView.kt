package com.kryptkode.characters.detail.view

import com.kryptkode.characters.entities.CharacterUi
import com.kryptkode.characters.entities.FilmUi
import com.kryptkode.characters.entities.PlanetUi
import com.kryptkode.characters.entities.SpeciesUi
import com.kryptkode.commonandroid.view.BaseObservableAppView

abstract class CharacterDetailView : BaseObservableAppView<CharacterDetailView.Listener>(){

    interface Listener{
        fun onBackClick()
        fun onReloadPlanet()
        fun onReloadFilms()
        fun onReloadSpecies()
    }

    abstract fun bindCharacter(character: CharacterUi)
    abstract fun hideFilmsLoading()
    abstract fun showFilmsLoading()
    abstract fun showLoadFilmsError(message: String)
    abstract fun showFilms(data: List<FilmUi>)
    abstract fun hidePlanetLoading()
    abstract fun showPlanetLoading()
    abstract fun showPlanet(data: PlanetUi)
    abstract fun showLoadPlanetError(message: String)
    abstract fun hideSpeciesLoading()
    abstract fun showLoadSpeciesError(message: String)
    abstract fun showSpeciesLoading()
    abstract fun showSpecies(data: List<SpeciesUi>)

}
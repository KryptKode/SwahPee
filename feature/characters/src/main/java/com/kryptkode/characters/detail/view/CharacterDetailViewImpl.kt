package com.kryptkode.characters.detail.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.kryptkode.characters.detail.view.filmlist.FilmListAdapter
import com.kryptkode.characters.detail.view.specieslist.SpeciesListAdapter
import com.kryptkode.characters.entities.CharacterUi
import com.kryptkode.characters.entities.FilmUi
import com.kryptkode.characters.entities.PlanetUi
import com.kryptkode.characters.entities.SpeciesUi
import com.kryptkode.commonandroid.extension.beGone
import com.kryptkode.commonandroid.extension.beVisible
import com.kryptkode.search.R
import com.kryptkode.search.databinding.LayoutCharacterDetailBinding

class CharacterDetailViewImpl(
        factory: CharacterDetailViewFactory,
        layoutInflater: LayoutInflater,
        parent: ViewGroup?
) : CharacterDetailView() {

    private val binding = LayoutCharacterDetailBinding.inflate(layoutInflater, parent, false)

    private val filmsAdapter = FilmListAdapter(factory)
    private val speciesAdapter = SpeciesListAdapter(factory)

    init {
        binding.tvTitle.setOnClickListener {
            onEachListener {
                it.onBackClick()
            }
        }

        binding.cardPlanet.retryButton.setOnClickListener {
            onEachListener {
                it.onReloadPlanet()
            }
        }

        binding.cardFilms.retryButton.setOnClickListener {
            onEachListener {
                it.onReloadFilms()
            }
        }

        binding.cardSpecies.retryButton.setOnClickListener {
            onEachListener {
                it.onReloadSpecies()
            }
        }

        setupFilmsPager()
        setupSpeciesPager()
    }

    private fun setupFilmsPager() {
        binding.cardFilms.filmsViewPager.adapter = filmsAdapter
        binding.cardFilms.filmsViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.cardFilms.filmsPageIndicator.setSelected(position)
            }
        })
    }

    private fun setupSpeciesPager() {
        binding.cardSpecies.speciesViewPager.adapter = filmsAdapter
        binding.cardSpecies.speciesViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.cardSpecies.speciesPageIndicator.setSelected(position)
            }
        })
    }

    override fun bindCharacter(character: CharacterUi) {
        binding.cardInfo.tvName.text = character.name
        binding.cardInfo.tvDob.text = character.birthYear
        binding.cardInfo.tvHeight.text = getString(R.string.character_height, character.heightCm, character.heightInches)
    }

    override fun hideFilmsLoading() {
        binding.cardFilms.loadingGroup.beGone()
        binding.cardFilms.filmViews.beVisible()
    }

    override fun showFilmsLoading() {
        binding.cardFilms.loadingGroup.beVisible()
        binding.cardFilms.filmViews.beGone()
    }

    override fun showLoadFilmsError(message: String) {
        binding.cardFilms.filmViews.beGone()
        binding.cardFilms.errorGroup.beVisible()
        binding.cardFilms.errorTextView.text = message
    }

    override fun showFilms(data: List<FilmUi>) {
        filmsAdapter.submitList(data)
    }

    override fun hidePlanetLoading() {
        binding.cardPlanet.loadingGroup.beGone()
        binding.cardPlanet.planetViews.beVisible()
    }

    override fun showPlanetLoading() {
        binding.cardPlanet.loadingGroup.beVisible()
        binding.cardPlanet.planetViews.beGone()
    }

    override fun showPlanet(data: PlanetUi) {
        binding.cardPlanet.tvTitle.text = data.name
        binding.cardPlanet.tvPopulation.text = data.population
    }

    override fun showLoadPlanetError(message: String) {
        binding.cardPlanet.planetViews.beGone()
        binding.cardPlanet.errorGroup.beVisible()
        binding.cardPlanet.errorTextView.text = message
    }

    override fun showSpecies(data: List<SpeciesUi>) {
        speciesAdapter.submitList(data)
    }

    override fun showLoadSpeciesError(message: String) {
        binding.cardSpecies.speciesViews.beGone()
        binding.cardSpecies.errorGroup.beVisible()
        binding.cardSpecies.errorTextView.text = message
    }

    override fun showSpeciesLoading() {
        binding.cardSpecies.loadingGroup.beVisible()
        binding.cardSpecies.speciesViews.beGone()
    }

    override fun hideSpeciesLoading() {
        binding.cardSpecies.loadingGroup.beGone()
        binding.cardSpecies.speciesViews.beVisible()
    }

    override val rootView: View
        get() = binding.root
}
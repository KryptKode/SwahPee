package com.kryptkode.characters.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kryptkode.characters.CharactersNavigator
import com.kryptkode.characters.DataState
import com.kryptkode.characters.detail.view.CharacterDetailView
import com.kryptkode.characters.detail.view.CharacterDetailViewFactory
import com.kryptkode.characters.entities.CharacterUi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterDetailFragment : Fragment(), CharacterDetailView.Listener {

    @Inject
    lateinit var navigator: CharactersNavigator

    @Inject
    lateinit var viewFactory: CharacterDetailViewFactory

    private lateinit var detailView: CharacterDetailView

    private val character by lazy { arguments?.getParcelable<CharacterUi>("character")!! }

    private val viewModel: CharacterDetailViewModel by viewModels()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        detailView = viewFactory.getCharacterDetailView(container)
        setupObservers()
        viewModel.getCharacterDetails(character)
        detailView.bindCharacter(character)
        return detailView.rootView
    }

    private fun setupObservers() {
        viewModel.films.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Error -> {
                    detailView.hideFilmsLoading()
                    detailView.showLoadFilmsError(it.message)
                }

                is DataState.Loading -> {
                    detailView.showFilmsLoading()
                }

                is DataState.Success -> {
                    detailView.hideFilmsLoading()
                    detailView.showFilms(it.data)
                }
            }
        }

        viewModel.planet.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Error -> {
                    detailView.hidePlanetLoading()
                    detailView.showLoadPlanetError(it.message)
                }

                is DataState.Loading -> {
                    detailView.showPlanetLoading()
                }

                is DataState.Success -> {
                    detailView.hidePlanetLoading()
                    detailView.showPlanet(it.data)
                }
            }
        }

        viewModel.species.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Error -> {
                    detailView.hideSpeciesLoading()
                    detailView.showLoadSpeciesError(it.message)
                }

                is DataState.Loading -> {
                    detailView.showSpeciesLoading()
                }

                is DataState.Success -> {
                    detailView.hideSpeciesLoading()
                    detailView.showSpecies(it.data)
                }
            }
        }

        viewModel.character.observe(viewLifecycleOwner) {
            detailView.bindCharacter(it)
        }
    }

    override fun onStart() {
        super.onStart()
        detailView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        detailView.unregisterListener(this)
    }

    override fun onReloadPlanet() {
        viewModel.loadPlanet()
    }

    override fun onReloadFilms() {
        viewModel.loadFilms()
    }

    override fun onReloadSpecies() {
        viewModel.loadSpecies()
    }

    override fun onBackClick() {
        navigator.navigateUp()
    }
}
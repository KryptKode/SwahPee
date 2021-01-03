package com.kryptkode.characters.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kryptkode.characters.CharacterUi
import com.kryptkode.characters.CharactersNavigator
import com.kryptkode.characters.detail.view.CharacterDetailView
import com.kryptkode.characters.detail.view.CharacterDetailViewFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterDetailFragment : Fragment(), CharacterDetailView.Listener {

    @Inject
    lateinit var navigator: CharactersNavigator

    @Inject
    lateinit var viewFactory: CharacterDetailViewFactory

    private lateinit var detailView: CharacterDetailView

    private val character by lazy { arguments?.getParcelable<CharacterUi>("character")!!}

    private val viewModel: CharacterDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailView = viewFactory.getCharacterDetailView(container)
        setupObservers()
        detailView.bindCharacter(character)
        return detailView.rootView
    }

    private fun setupObservers() {

    }

    override fun onStart() {
        super.onStart()
        detailView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        detailView.unregisterListener(this)
    }

    override fun onBackClick() {
        navigator.navigateUp()
    }

}
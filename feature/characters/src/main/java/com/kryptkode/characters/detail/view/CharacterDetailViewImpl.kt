package com.kryptkode.characters.detail.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.kryptkode.characters.CharacterUi
import com.kryptkode.characters.detail.view.filmlist.FilmListAdapter
import com.kryptkode.search.R
import com.kryptkode.search.databinding.LayoutCharacterDetailBinding

class CharacterDetailViewImpl(
    factory: CharacterDetailViewFactory,
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : CharacterDetailView() {

    private val binding  =  LayoutCharacterDetailBinding.inflate(layoutInflater, parent, false)

    private val filmsAdapter = FilmListAdapter(factory)

    init {
        binding.tvTitle.setOnClickListener {
            onEachListener {
                it.onBackClick()
            }
        }

        setupFilmsPager()
    }

    private fun setupFilmsPager() {
        binding.cardFilms.filmsViewPager.adapter = filmsAdapter
        binding.cardFilms.filmsViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.cardFilms.filmsPageIndicator.setSelected(position)
            }
        })
    }

    override fun bindCharacter(character: CharacterUi) {
        binding.cardInfo.tvName.text = character.name
        binding.cardInfo.tvDob.text = character.birthYear
        binding.cardInfo.tvHeight.text = getString(R.string.character_height, character.heightCm, character.heightInches)
    }

    override val rootView: View
        get() = binding.root
}
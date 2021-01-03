package com.kryptkode.charactersearch.view.itemview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kryptkode.charactersearch.R
import com.kryptkode.charactersearch.UiCharacter
import com.kryptkode.charactersearch.databinding.ItemCharacterBinding

class CharacterItemViewImpl (
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : CharacterItemView() {

    private val binding = ItemCharacterBinding.inflate(layoutInflater, parent, false)

    @SuppressLint("DefaultLocale")
    override fun bind(item: UiCharacter) {
        binding.nameTextView.text = item.name.capitalize()
        binding.dobTextView.text = item.birthYear.capitalize()
        binding.heightTextView.text = getString(R.string.height, item.height)
        binding.root.setOnClickListener {
            onEachListener {
                it.onFarmClick(item)
            }
        }
    }

    override val rootView: View
        get() = binding.root
}
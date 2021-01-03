package com.kryptkode.characters.search.view.itemview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kryptkode.characters.CharacterUi
import com.kryptkode.search.R
import com.kryptkode.search.databinding.ItemCharacterBinding

class CharacterItemViewImpl (
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : CharacterItemView() {

    private val binding = ItemCharacterBinding.inflate(layoutInflater, parent, false)

    @SuppressLint("DefaultLocale")
    override fun bind(item: CharacterUi) {
        binding.nameTextView.text = item.name.capitalize()
        binding.dobTextView.text = item.birthYear.capitalize()
        binding.heightTextView.text = getString(R.string.height, item.heightCm)
        binding.root.setOnClickListener {
            onEachListener {
                it.onFarmClick(item)
            }
        }
    }

    override val rootView: View
        get() = binding.root
}
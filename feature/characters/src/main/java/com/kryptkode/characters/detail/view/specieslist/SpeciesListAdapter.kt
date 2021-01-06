package com.kryptkode.characters.detail.view.specieslist

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kryptkode.characters.detail.view.CharacterDetailViewFactory
import com.kryptkode.characters.entities.SpeciesUi


class SpeciesListAdapter (
    private val viewFactory: CharacterDetailViewFactory
) : ListAdapter<SpeciesUi, SpeciesListAdapter.SpeciesListViewHolder>(DIFF_UTIL) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesListViewHolder {
        return SpeciesListViewHolder(viewFactory.getSpeciesItemView(parent))
    }

    override fun onBindViewHolder(holder: SpeciesListViewHolder, position: Int) {
        holder.speciesItemView.bind(getItem(position))
    }

    class SpeciesListViewHolder(val speciesItemView: SpeciesItemView) :
        RecyclerView.ViewHolder(speciesItemView.rootView)

    companion object {
        val DIFF_UTIL = object: DiffUtil.ItemCallback<SpeciesUi>(){
            override fun areContentsTheSame(oldItem: SpeciesUi, newItem: SpeciesUi): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: SpeciesUi, newItem: SpeciesUi): Boolean {
                return oldItem == newItem
            }
        }
    }
}
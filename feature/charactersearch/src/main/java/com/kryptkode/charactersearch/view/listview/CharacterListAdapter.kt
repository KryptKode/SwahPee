package com.kryptkode.charactersearch.view.listview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kryptkode.charactersearch.UiCharacter
import com.kryptkode.charactersearch.view.SearchCharacterViewFactory
import com.kryptkode.charactersearch.view.itemview.CharacterItemView


class CharacterListAdapter (
    private val viewFactory: SearchCharacterViewFactory,
    private val onClickItem: (UiCharacter) -> Unit
) : ListAdapter<UiCharacter, CharacterListAdapter.FarmListViewHolder>(DIFF_UTIL), CharacterItemView.Listener {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmListViewHolder {
        val viewHolder = FarmListViewHolder(viewFactory.getCharacterItemView(parent))
        viewHolder.farmerListItemView.registerListener(this)
        return viewHolder
    }

    override fun onBindViewHolder(holder: FarmListViewHolder, position: Int) {
        holder.farmerListItemView.bind(getItem(position))
    }

    class FarmListViewHolder(val farmerListItemView: CharacterItemView) :
        RecyclerView.ViewHolder(farmerListItemView.rootView)

    companion object {
        val DIFF_UTIL = object: DiffUtil.ItemCallback<UiCharacter>(){
            override fun areContentsTheSame(oldItem: UiCharacter, newItem: UiCharacter): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: UiCharacter, newItem: UiCharacter): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onFarmClick(item: UiCharacter) {
        onClickItem(item)
    }
}
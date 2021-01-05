package com.kryptkode.characters.search.view.listview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kryptkode.characters.entities.CharacterUi
import com.kryptkode.characters.search.view.SearchCharacterViewFactory
import com.kryptkode.characters.search.view.itemview.CharacterItemView


class CharacterListAdapter (
    private val viewFactory: SearchCharacterViewFactory,
    private val onClickItem: (CharacterUi) -> Unit
) : ListAdapter<CharacterUi, CharacterListAdapter.FarmListViewHolder>(DIFF_UTIL), CharacterItemView.Listener {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmListViewHolder {
        val viewHolder = FarmListViewHolder(viewFactory.getCharacterItemView(parent))
        viewHolder.characterItemView.registerListener(this)
        return viewHolder
    }

    override fun onBindViewHolder(holder: FarmListViewHolder, position: Int) {
        holder.characterItemView.bind(getItem(position))
    }

    class FarmListViewHolder(val characterItemView: CharacterItemView) :
        RecyclerView.ViewHolder(characterItemView.rootView)

    companion object {
        val DIFF_UTIL = object: DiffUtil.ItemCallback<CharacterUi>(){
            override fun areContentsTheSame(oldItem: CharacterUi, newItem: CharacterUi): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: CharacterUi, newItem: CharacterUi): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onFarmClick(item: CharacterUi) {
        onClickItem(item)
    }
}
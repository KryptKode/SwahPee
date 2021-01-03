package com.kryptkode.characters.detail.view.filmlist

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kryptkode.characters.detail.FilmUi
import com.kryptkode.characters.detail.view.CharacterDetailViewFactory


class FilmListAdapter (
    private val viewFactory: CharacterDetailViewFactory
) : ListAdapter<FilmUi, FilmListAdapter.FarmListViewHolder>(DIFF_UTIL) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmListViewHolder {
        return FarmListViewHolder(viewFactory.getFilmItemView(parent))
    }

    override fun onBindViewHolder(holder: FarmListViewHolder, position: Int) {
        holder.filmItemView.bind(getItem(position))
    }

    class FarmListViewHolder(val filmItemView: FilmItemView) :
        RecyclerView.ViewHolder(filmItemView.rootView)

    companion object {
        val DIFF_UTIL = object: DiffUtil.ItemCallback<FilmUi>(){
            override fun areContentsTheSame(oldItem: FilmUi, newItem: FilmUi): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: FilmUi, newItem: FilmUi): Boolean {
                return oldItem == newItem
            }
        }
    }
}
package com.kryptkode.characters.detail.view.filmlist

import com.kryptkode.characters.detail.FilmUi
import com.kryptkode.commonandroid.view.BaseAppView

abstract class FilmItemView: BaseAppView() {
    abstract fun bind(item: FilmUi)
}
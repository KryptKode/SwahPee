package com.kryptkode.characters.detail.view.specieslist

import com.kryptkode.characters.entities.SpeciesUi
import com.kryptkode.commonandroid.view.BaseAppView

abstract class SpeciesItemView: BaseAppView() {
    abstract fun bind(item: SpeciesUi)
}
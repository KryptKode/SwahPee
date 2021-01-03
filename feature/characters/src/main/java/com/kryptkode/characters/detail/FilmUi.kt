package com.kryptkode.characters.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmUi(
    val title: String,
    val openingCrawl: String
) : Parcelable
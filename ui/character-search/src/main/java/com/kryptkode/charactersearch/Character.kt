package com.kryptkode.charactersearch

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val birthYear: String,
    val height: String,
    val url: String
): Parcelable
package com.kryptkode.characters

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterUi(
    val name: String,
    val birthYear: String,
    val heightCm: String,
    val heightInches: String,
    val url: String
): Parcelable
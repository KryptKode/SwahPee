package com.kryptkode.remote.entities.film

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmRemote(
    @field:Json(name = "title") val title: String,
    @field:Json(name = "openingCrawl") val openingCrawl: String
)
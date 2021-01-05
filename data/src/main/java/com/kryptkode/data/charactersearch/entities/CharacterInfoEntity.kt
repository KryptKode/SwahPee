package com.kryptkode.data.charactersearch.entities

data class CharacterInfoEntity(
    val name: String,
    val url: String,
    val birthYear: String,
    val height: String,
    val homeWorld: String,
    val films: List<String>,
    val species: List<String>,
)
package com.kryptkode.data.charactersearch.entities

data class PlanetEntity(
        val name: String,
        val population: String
) {
    companion object {
        val NO_PLANET = PlanetEntity("", "")
    }
}
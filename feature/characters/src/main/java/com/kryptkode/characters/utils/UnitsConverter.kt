package com.kryptkode.characters.utils

import java.math.BigDecimal
import java.math.RoundingMode

object UnitsConverter {

    fun convertCmToInches(centimeters: String): String =
        (BigDecimal(centimeters.toDouble() * 0.393701).setScale(
            3,
            RoundingMode.HALF_EVEN
        )).toString()

    fun sanitizePopulation(population: String): String {
        return if (population.contains("unknown", ignoreCase = true)) "0" else population
    }
}
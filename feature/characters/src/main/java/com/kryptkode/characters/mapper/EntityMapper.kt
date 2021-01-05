package com.kryptkode.characters.mapper

interface EntityMapper<E, D> {
    fun mapToEntity(entity: D): E
}
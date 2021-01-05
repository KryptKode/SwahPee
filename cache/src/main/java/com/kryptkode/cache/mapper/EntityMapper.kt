package com.kryptkode.cache.mapper

interface EntityMapper<E, D> {

    fun mapFromEntity(entity: E): D

    fun mapToEntity(entity: D): E
}
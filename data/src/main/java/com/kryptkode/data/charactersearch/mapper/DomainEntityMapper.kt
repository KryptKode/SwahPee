package com.kryptkode.data.charactersearch.mapper

interface DomainEntityMapper<E, D> {

    fun mapFromEntity(entity: E): D

    fun mapToEntity(entity: D): E

    fun mapFromEntityList(entities: List<E>): List<D> {
        return entities.map {
            mapFromEntity(it)
        }
    }

    fun mapToEntityList(entities: List<D>): List<E> {
        return entities.map {
            mapToEntity(it)
        }
    }
}
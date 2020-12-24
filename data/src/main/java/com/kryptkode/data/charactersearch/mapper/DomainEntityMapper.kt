package com.kryptkode.data.charactersearch.mapper

interface DomainEntityMapper<E, D> {

    fun mapFromEntity(entity: E): D

    fun mapToEntity(entity: D): E
}
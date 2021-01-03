package com.kryptkode.commonandroid

interface EntityMapper<E, D> {

    fun mapFromEntity(entity: E): D

    fun mapToEntity(entity: D): E
}
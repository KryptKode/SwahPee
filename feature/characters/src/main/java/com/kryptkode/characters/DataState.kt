package com.kryptkode.characters

sealed class DataState<out T> {
    object Loading : DataState<Nothing>()
    class Success<T>(val data: T) : DataState<T>()
    class Error(val message: String) : DataState<Nothing>()
}
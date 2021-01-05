package com.kryptkode.cache.converter

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    @JvmStatic
    val formatter = SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH)

    @TypeConverter
    @JvmStatic
    fun toDate(text: String): Date = formatter.parse(text)!!

    @TypeConverter
    @JvmStatic
    fun toText(date: Date): String = formatter.format(date)
}
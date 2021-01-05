package com.kryptkode.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kryptkode.cache.character.CharacterDao
import com.kryptkode.cache.character.DbCharacter
import com.kryptkode.cache.converter.DateConverter
import com.kryptkode.cache.converter.StringListConverter

/**
 * Database schema that holds the list of repos.
 */
@Database(
    entities = [DbCharacter::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    StringListConverter::class,
    DateConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun charactersDao(): CharacterDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "swahpee.db"
            )
                .build()
    }

}

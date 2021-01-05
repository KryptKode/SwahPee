package com.kryptkode.cache.character

import androidx.room.Dao
import androidx.room.Query
import com.kryptkode.farmz.app.data.db.base.BaseDao
import kotlinx.coroutines.flow.Flow


@Dao
abstract class CharacterDao : BaseDao<DbCharacter>{
    @Query("SELECT * FROM characters WHERE url=:url")
    abstract fun getCharacter(url:String): Flow<DbCharacter>
}
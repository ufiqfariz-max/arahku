package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.local.entity.DoaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DoaDao {

    @Query("SELECT * FROM table_doa ORDER BY id ASC")
    fun getAllDoa(): Flow<List<DoaEntity>>

    @Query("""
        SELECT * FROM table_doa 
        WHERE title LIKE '%' || :query || '%' 
           OR latin LIKE '%' || :query || '%' 
           OR translation LIKE '%' || :query || '%'
           OR category LIKE '%' || :query || '%'
           OR source LIKE '%' || :query || '%'
           OR reference LIKE '%' || :query || '%'
        ORDER BY id ASC
    """)
    fun searchDoa(query: String): Flow<List<DoaEntity>>

    @Query("SELECT * FROM table_doa WHERE category = :category ORDER BY id ASC")
    fun getDoaByCategory(category: String): Flow<List<DoaEntity>>

    @Query("SELECT * FROM table_doa WHERE is_favorite = 1 ORDER BY id ASC")
    fun getFavoriteDoa(): Flow<List<DoaEntity>>

    @Query("UPDATE table_doa SET is_favorite = :isFavorite WHERE id = :id")
    suspend fun updateFavorite(id: Int, isFavorite: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(doas: List<DoaEntity>)

    @Query("SELECT COUNT(*) FROM table_doa")
    suspend fun getCount(): Int
}

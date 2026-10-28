package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.PrayerChecklistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerDao {

    @Query("SELECT * FROM table_prayer_checklist WHERE date = :date LIMIT 1")
    fun getChecklistByDate(date: String): Flow<PrayerChecklistEntity?>

    @Query("SELECT * FROM table_prayer_checklist WHERE date = :date LIMIT 1")
    suspend fun getChecklistSync(date: String): PrayerChecklistEntity?

    @Query("SELECT * FROM table_prayer_checklist ORDER BY date DESC LIMIT :limit")
    fun getRecentChecklists(limit: Int = 14): Flow<List<PrayerChecklistEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(checklist: PrayerChecklistEntity)
}

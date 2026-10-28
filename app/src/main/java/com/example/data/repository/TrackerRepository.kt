package com.example.data.repository

import com.example.data.local.dao.TrackerDao
import com.example.data.local.entity.PrayerChecklistEntity
import kotlinx.coroutines.flow.Flow

class TrackerRepository(private val trackerDao: TrackerDao) {

    fun getChecklistByDate(date: String): Flow<PrayerChecklistEntity?> {
        return trackerDao.getChecklistByDate(date)
    }

    suspend fun getChecklistSync(date: String): PrayerChecklistEntity? {
        return trackerDao.getChecklistSync(date)
    }

    fun getRecentChecklists(limit: Int = 14): Flow<List<PrayerChecklistEntity>> {
        return trackerDao.getRecentChecklists(limit)
    }

    suspend fun saveChecklist(checklist: PrayerChecklistEntity) {
        trackerDao.insertOrUpdate(checklist)
    }
}

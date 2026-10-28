package com.example.data.repository

import com.example.data.local.dao.DoaDao
import com.example.data.local.entity.DoaEntity
import kotlinx.coroutines.flow.Flow

class DoaRepository(private val doaDao: DoaDao) {

    fun getAllDoa(): Flow<List<DoaEntity>> = doaDao.getAllDoa()

    fun searchDoa(query: String): Flow<List<DoaEntity>> {
        return if (query.isBlank()) {
            doaDao.getAllDoa()
        } else {
            doaDao.searchDoa(query.trim())
        }
    }

    fun getDoaByCategory(category: String): Flow<List<DoaEntity>> {
        return if (category == "Semua") {
            doaDao.getAllDoa()
        } else {
            doaDao.getDoaByCategory(category)
        }
    }

    fun getFavoriteDoa(): Flow<List<DoaEntity>> = doaDao.getFavoriteDoa()

    suspend fun toggleFavorite(id: Int, currentFavorite: Boolean) {
        doaDao.updateFavorite(id, !currentFavorite)
    }
}

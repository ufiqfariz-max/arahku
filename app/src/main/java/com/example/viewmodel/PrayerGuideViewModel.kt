package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.PrayerGuideData
import com.example.data.model.PrayerGuideCategory
import com.example.data.model.PrayerGuideItem
import com.example.data.model.PrayerRole
import com.example.data.model.PrayerTimeType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class PrayerGuideViewModel : ViewModel() {

    private val _selectedCategory = MutableStateFlow<PrayerGuideCategory?>(null) // null = Semua
    val selectedCategory: StateFlow<PrayerGuideCategory?> = _selectedCategory

    private val _selectedPrayerTime = MutableStateFlow(PrayerTimeType.ALL)
    val selectedPrayerTime: StateFlow<PrayerTimeType> = _selectedPrayerTime

    private val _selectedRole = MutableStateFlow(PrayerRole.ALL)
    val selectedRole: StateFlow<PrayerRole> = _selectedRole

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    val filteredItems: StateFlow<List<PrayerGuideItem>> = combine(
        _selectedCategory,
        _selectedPrayerTime,
        _selectedRole,
        _searchQuery
    ) { category, prayerTime, role, query ->
        PrayerGuideData.items.filter { item ->
            val matchCategory = category == null || item.category == category
            val matchPrayerTime = when {
                item.category != PrayerGuideCategory.NIAT_5_WAKTU -> true
                prayerTime == PrayerTimeType.ALL -> true
                else -> item.prayerTime == prayerTime
            }
            val matchRole = when {
                item.category != PrayerGuideCategory.NIAT_5_WAKTU -> true
                role == PrayerRole.ALL -> true
                else -> item.role == role
            }
            val matchQuery = if (query.isBlank()) {
                true
            } else {
                val q = query.trim().lowercase()
                item.title.lowercase().contains(q) ||
                        item.subtitle.lowercase().contains(q) ||
                        item.latin.lowercase().contains(q) ||
                        item.translation.lowercase().contains(q) ||
                        item.arabic.lowercase().contains(q) ||
                        item.explanation.lowercase().contains(q)
            }
            matchCategory && matchPrayerTime && matchRole && matchQuery
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), PrayerGuideData.items)

    fun selectCategory(category: PrayerGuideCategory?) {
        _selectedCategory.value = category
    }

    fun selectPrayerTime(prayerTime: PrayerTimeType) {
        _selectedPrayerTime.value = prayerTime
    }

    fun selectRole(role: PrayerRole) {
        _selectedRole.value = role
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun clearSearch() {
        _searchQuery.value = ""
    }
}

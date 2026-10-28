package com.example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.data.local.DzikirAlRabiahData
import com.example.data.model.DzikirItem
import com.example.data.model.DzikirType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DzikirViewModel : ViewModel() {

    private val _selectedType = MutableStateFlow(DzikirType.PAGI)
    val selectedType: StateFlow<DzikirType> = _selectedType.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _filteredDzikir = MutableStateFlow<List<DzikirItem>>(emptyList())
    val dzikirList: StateFlow<List<DzikirItem>> = _filteredDzikir.asStateFlow()

    // Map: Dzikir ID -> Current Tap Count
    private val _counts = MutableStateFlow<Map<Int, Int>>(emptyMap())
    val counts: StateFlow<Map<Int, Int>> = _counts.asStateFlow()

    init {
        updateFilteredList()
    }

    fun selectType(type: DzikirType) {
        _selectedType.value = type
        updateFilteredList()
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        updateFilteredList()
    }

    fun incrementCount(id: Int, target: Int) {
        val current = _counts.value[id] ?: 0
        if (current < target) {
            _counts.value = _counts.value + (id to current + 1)
        }
    }

    fun resetCount(id: Int) {
        _counts.value = _counts.value - id
    }

    fun resetAllCounts() {
        val currentTypeIds = DzikirAlRabiahData.dzikirList
            .filter { it.type == _selectedType.value }
            .map { it.id }
            .toSet()

        _counts.value = _counts.value.filterKeys { it !in currentTypeIds }
    }

    private fun updateFilteredList() {
        val type = _selectedType.value
        val query = _searchQuery.value.trim().lowercase()

        _filteredDzikir.value = DzikirAlRabiahData.dzikirList.filter { item ->
            val matchesType = item.type == type
            val matchesQuery = query.isBlank() ||
                    item.title.lowercase().contains(query) ||
                    item.latin.lowercase().contains(query) ||
                    item.translation.lowercase().contains(query) ||
                    item.fadhilah.lowercase().contains(query)
            matchesType && matchesQuery
        }
    }
}

package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.entity.DoaEntity
import com.example.data.repository.DoaRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class DoaViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DoaRepository

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow("Semua")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    val categories = listOf(
        "Semua",
        "Bangun & Tidur",
        "Pakaian & Toilet",
        "Wudhu & Shalat",
        "Rumah & Masjid",
        "Makan & Minum",
        "Pagi & Petang",
        "Safar & Kendaraan",
        "Perlindungan & Sakit",
        "Keluarga & Adab",
        "Favorit"
    )

    val doas: StateFlow<List<DoaEntity>>

    init {
        val database = AppDatabase.getDatabase(application, viewModelScope)
        repository = DoaRepository(database.doaDao())

        doas = combine(_searchQuery, _selectedCategory) { query, category ->
            Pair(query, category)
        }.flatMapLatest { (query, category) ->
            when {
                query.isNotBlank() -> repository.searchDoa(query)
                category == "Favorit" -> repository.getFavoriteDoa()
                category != "Semua" -> repository.getDoaByCategory(category)
                else -> repository.getAllDoa()
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun selectCategory(category: String) {
        _selectedCategory.value = category
    }

    fun toggleFavorite(doa: DoaEntity) {
        viewModelScope.launch {
            repository.toggleFavorite(doa.id, doa.isFavorite)
        }
    }
}

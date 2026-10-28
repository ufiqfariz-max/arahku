package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.AstronomyChapter
import com.example.data.repository.AstronomyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AstronomyViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AstronomyRepository(application)

    private val _allChapters = MutableStateFlow<List<AstronomyChapter>>(emptyList())
    private val _filteredChapters = MutableStateFlow<List<AstronomyChapter>>(emptyList())
    val chapters: StateFlow<List<AstronomyChapter>> = _filteredChapters.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow("Semua")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    val categories = listOf(
        "Semua",
        "Dasar Astronomi",
        "Mekanika Langit",
        "Astrometri",
        "Tata Surya",
        "Astrofisika",
        "Relativitas & Lubang Hitam",
        "Kosmologi",
        "Instrumentasi",
        "Eksoplanet & Astrobiologi"
    )

    private val _expandedChapterId = MutableStateFlow<Int?>(1)
    val expandedChapterId: StateFlow<Int?> = _expandedChapterId.asStateFlow()

    init {
        loadChapters()
    }

    private fun loadChapters() {
        viewModelScope.launch {
            val list = repository.loadChapters()
            _allChapters.value = list
            filterChapters()
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        filterChapters()
    }

    fun selectCategory(category: String) {
        _selectedCategory.value = category
        filterChapters()
    }

    fun toggleExpandChapter(chapterId: Int) {
        _expandedChapterId.value = if (_expandedChapterId.value == chapterId) null else chapterId
    }

    private fun filterChapters() {
        val query = _searchQuery.value.trim().lowercase()
        val category = _selectedCategory.value

        _filteredChapters.value = _allChapters.value.filter { chapter ->
            val matchesCategory = category == "Semua" || chapter.category.equals(category, ignoreCase = true)
            val matchesQuery = query.isBlank() ||
                    chapter.title.lowercase().contains(query) ||
                    chapter.number.lowercase().contains(query) ||
                    chapter.summary.lowercase().contains(query) ||
                    chapter.tags.any { it.lowercase().contains(query) } ||
                    chapter.sections.any {
                        it.title.lowercase().contains(query) ||
                                it.explanation.lowercase().contains(query) ||
                                it.formulaOrFacts.lowercase().contains(query) ||
                                it.keyPoints.any { kp -> kp.lowercase().contains(query) }
                    }
            matchesCategory && matchesQuery
        }
    }
}

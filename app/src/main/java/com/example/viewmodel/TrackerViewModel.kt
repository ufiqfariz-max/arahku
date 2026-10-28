package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.entity.PrayerChecklistEntity
import com.example.data.repository.TrackerRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalCoroutinesApi::class)
class TrackerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TrackerRepository
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val todayDateString: String = dateFormat.format(Date())

    private val _selectedDate = MutableStateFlow(todayDateString)
    val selectedDate: StateFlow<String> = _selectedDate.asStateFlow()

    val currentChecklist: StateFlow<PrayerChecklistEntity>
    val recentChecklists: StateFlow<List<PrayerChecklistEntity>>

    init {
        val database = AppDatabase.getDatabase(application, viewModelScope)
        repository = TrackerRepository(database.trackerDao())

        currentChecklist = _selectedDate.flatMapLatest { date ->
            repository.getChecklistByDate(date).map { entity ->
                entity ?: PrayerChecklistEntity(date = date)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = PrayerChecklistEntity(date = todayDateString)
        )

        recentChecklists = repository.getRecentChecklists(14).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    }

    fun selectDate(date: String) {
        _selectedDate.value = date
    }

    fun toggleFajr() {
        val current = currentChecklist.value
        save(current.copy(fajr = !current.fajr))
    }

    fun toggleDhuhr() {
        val current = currentChecklist.value
        save(current.copy(dhuhr = !current.dhuhr))
    }

    fun toggleAsr() {
        val current = currentChecklist.value
        save(current.copy(asr = !current.asr))
    }

    fun toggleMaghrib() {
        val current = currentChecklist.value
        save(current.copy(maghrib = !current.maghrib))
    }

    fun toggleIsha() {
        val current = currentChecklist.value
        save(current.copy(isha = !current.isha))
    }

    fun toggleTahajjud() {
        val current = currentChecklist.value
        save(current.copy(tahajjud = !current.tahajjud))
    }

    fun toggleDhuha() {
        val current = currentChecklist.value
        save(current.copy(dhuha = !current.dhuha))
    }

    fun toggleRawatib() {
        val current = currentChecklist.value
        save(current.copy(rawatib = !current.rawatib))
    }

    fun toggleWitir() {
        val current = currentChecklist.value
        save(current.copy(witir = !current.witir))
    }

    fun toggleDhikr() {
        val current = currentChecklist.value
        save(current.copy(dhikrDone = !current.dhikrDone))
    }

    fun incrementQuranPages() {
        val current = currentChecklist.value
        save(current.copy(quranPages = current.quranPages + 1))
    }

    fun decrementQuranPages() {
        val current = currentChecklist.value
        if (current.quranPages > 0) {
            save(current.copy(quranPages = current.quranPages - 1))
        }
    }

    private fun save(updated: PrayerChecklistEntity) {
        viewModelScope.launch {
            repository.saveChecklist(updated)
        }
    }
}

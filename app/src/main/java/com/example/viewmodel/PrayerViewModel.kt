package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.CityLocation
import com.example.data.model.PrayerSchedule
import com.example.prayer.alarm.AdhanAlarmScheduler
import com.example.prayer.calculation.LocationProvider
import com.example.prayer.calculation.PrayerTimesCalculator
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar

class PrayerViewModel(application: Application) : AndroidViewModel(application) {

    private val calculator = PrayerTimesCalculator()
    private val alarmScheduler = AdhanAlarmScheduler(application)

    private val _selectedCity = MutableStateFlow(LocationProvider.defaultCity)
    val selectedCity: StateFlow<CityLocation> = _selectedCity.asStateFlow()

    private val _prayerSchedule = MutableStateFlow<PrayerSchedule?>(null)
    val prayerSchedule: StateFlow<PrayerSchedule?> = _prayerSchedule.asStateFlow()

    private val _isAlarmEnabled = MutableStateFlow(true)
    val isAlarmEnabled: StateFlow<Boolean> = _isAlarmEnabled.asStateFlow()

    val availableCities = LocationProvider.indonesianCities

    init {
        updateSchedule()
        startCountdownTicker()
    }

    fun selectCity(city: CityLocation) {
        _selectedCity.value = city
        updateSchedule()
        if (_isAlarmEnabled.value) {
            alarmScheduler.scheduleNextPrayerAlarm(
                latitude = city.latitude,
                longitude = city.longitude,
                timezone = city.timezoneHours,
                cityName = city.name
            )
        }
    }

    fun setCustomCoordinates(lat: Double, lng: Double, cityName: String = "GPS Lokasi Saya") {
        // Asumsi zona waktu Indonesia berdasarkan bujur
        val timezone = when {
            lng < 110.0 -> 7.0 // WIB
            lng < 125.0 -> 8.0 // WITA
            else -> 9.0        // WIT
        }
        val customCity = CityLocation(cityName, "Koordinat GPS", lat, lng, timezone)
        _selectedCity.value = customCity
        updateSchedule()
    }

    fun toggleAlarm() {
        val newState = !_isAlarmEnabled.value
        _isAlarmEnabled.value = newState
        val city = _selectedCity.value
        if (newState) {
            alarmScheduler.scheduleNextPrayerAlarm(
                latitude = city.latitude,
                longitude = city.longitude,
                timezone = city.timezoneHours,
                cityName = city.name
            )
        } else {
            alarmScheduler.cancelAlarm()
        }
    }

    private fun updateSchedule() {
        val city = _selectedCity.value
        val schedule = calculator.calculatePrayers(
            latitude = city.latitude,
            longitude = city.longitude,
            timezone = city.timezoneHours,
            calendar = Calendar.getInstance(),
            cityName = city.name
        )
        _prayerSchedule.value = schedule
    }

    private fun startCountdownTicker() {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                updateSchedule()
            }
        }
    }
}

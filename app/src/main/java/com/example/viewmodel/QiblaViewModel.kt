package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.CityLocation
import com.example.data.model.QiblaData
import com.example.prayer.calculation.LocationProvider
import com.example.qibla.calculation.QiblaCalculator
import com.example.qibla.sensor.CompassSensorManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.math.abs

class QiblaViewModel(application: Application) : AndroidViewModel(application) {

    private val sensorManager = CompassSensorManager(application)

    private val _currentCity = MutableStateFlow(LocationProvider.defaultCity)
    val currentCity: StateFlow<CityLocation> = _currentCity.asStateFlow()

    private val _qiblaData = MutableStateFlow(
        QiblaData(
            qiblaBearing = 295.2f,
            deviceAzimuth = 0f,
            relativeAngle = 0f,
            distanceKm = 7915.0,
            isFacingQibla = false,
            accuracy = "Menginisialisasi Sensor..."
        )
    )
    val qiblaData: StateFlow<QiblaData> = _qiblaData.asStateFlow()

    private val _isTilted = MutableStateFlow(false)
    val isTilted: StateFlow<Boolean> = _isTilted.asStateFlow()

    private val _hasSensors = MutableStateFlow(true)
    val hasSensors: StateFlow<Boolean> = _hasSensors.asStateFlow()

    val availableCities = LocationProvider.indonesianCities

    init {
        calculateAndStartSensor()
    }

    fun updateLocation(city: CityLocation) {
        _currentCity.value = city
        calculateAndStartSensor()
    }

    fun updateGpsCoordinates(lat: Double, lng: Double) {
        val gpsCity = CityLocation("GPS Posisi Saat Ini", "Perangkat", lat, lng, 7.0)
        _currentCity.value = gpsCity
        calculateAndStartSensor()
    }

    private fun calculateAndStartSensor() {
        val city = _currentCity.value
        val qiblaBearing = QiblaCalculator.calculateQiblaBearing(city.latitude, city.longitude)
        val distance = QiblaCalculator.calculateDistanceToKaabaKm(city.latitude, city.longitude)

        viewModelScope.launch {
            sensorManager.getCompassDataFlow().collect { sensorData ->
                _hasSensors.value = sensorData.hasSensors
                _isTilted.value = sensorData.isTilted

                val deviceAzimuth = sensorData.azimuthDegrees
                // Sudut relatif jarum kiblat terhadap kepala smartphone
                val relative = ((qiblaBearing - deviceAzimuth + 360f) % 360f)

                // Dianggap menghadap kiblat jika perbedaan sudut dalam batas +/- 3 derajat
                val diffFromZero = if (relative > 180f) 360f - relative else relative
                val isFacing = diffFromZero <= 3.5f

                _qiblaData.value = QiblaData(
                    qiblaBearing = qiblaBearing,
                    deviceAzimuth = deviceAzimuth,
                    relativeAngle = relative,
                    distanceKm = distance,
                    isFacingQibla = isFacing,
                    accuracy = sensorData.accuracyText
                )
            }
        }
    }
}

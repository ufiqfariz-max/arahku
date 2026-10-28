package com.example.data.model

data class QiblaData(
    val qiblaBearing: Float,      // Qibla direction relative to True North in degrees [0, 360)
    val deviceAzimuth: Float,     // Current phone azimuth heading relative to True North [0, 360)
    val relativeAngle: Float,     // Relative difference: deviceAzimuth to Qibla (0 = aligned)
    val distanceKm: Double,       // Great-Circle distance to Ka'bah in kilometers
    val isFacingQibla: Boolean,   // True when within +/- 3 degrees of Ka'bah
    val accuracy: String          // Sensor accuracy status (Akurat, Sedang, Perlu Kalibrasi)
)

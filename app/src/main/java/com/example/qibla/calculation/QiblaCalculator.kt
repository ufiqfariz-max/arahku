package com.example.qibla.calculation

import kotlin.math.*

object QiblaCalculator {

    // Koordinat Geografis Ka'bah di Masjidil Haram, Makkah
    const val KAABA_LATITUDE = 21.422487
    const val KAABA_LONGITUDE = 39.826206
    private const val EARTH_RADIUS_KM = 6371.0

    /**
     * Menghitung sudut azimut arah kiblat dari koordinat pengamat menggunakan
     * rumus Trigonometri Bola (Spherical Trigonometry / Great-Circle Bearing).
     *
     * Rumus:
     * tan(Q) = sin(Δλ) / (cos(φ1) * tan(φ2) - sin(φ1) * cos(Δλ))
     *
     * @param userLat Lintang lokasi pengamat dalam derajat desimal (-90 sampai +90)
     * @param userLng Bujur lokasi pengamat dalam derajat desimal (-180 sampai +180)
     * @return Sudut azimut kiblat dari Utara Sejati (True North) dalam rentang [0.0, 360.0) derajat
     */
    fun calculateQiblaBearing(userLat: Double, userLng: Double): Float {
        val phi1 = Math.toRadians(userLat)
        val phi2 = Math.toRadians(KAABA_LATITUDE)
        val deltaLambda = Math.toRadians(KAABA_LONGITUDE - userLng)

        val y = sin(deltaLambda)
        val x = cos(phi1) * tan(phi2) - sin(phi1) * cos(deltaLambda)

        val qiblaRad = atan2(y, x)
        val qiblaDeg = Math.toDegrees(qiblaRad)

        return ((qiblaDeg + 360.0) % 360.0).toFloat()
    }

    /**
     * Menghitung jarak lingkaran besar (Great-Circle Distance) ke Ka'bah menggunakan formula Haversine.
     *
     * @return Jarak ke Ka'bah dalam satuan kilometer (km)
     */
    fun calculateDistanceToKaabaKm(userLat: Double, userLng: Double): Double {
        val phi1 = Math.toRadians(userLat)
        val phi2 = Math.toRadians(KAABA_LATITUDE)
        val deltaPhi = Math.toRadians(KAABA_LATITUDE - userLat)
        val deltaLambda = Math.toRadians(KAABA_LONGITUDE - userLng)

        val a = sin(deltaPhi / 2).pow(2) + cos(phi1) * cos(phi2) * sin(deltaLambda / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return EARTH_RADIUS_KM * c
    }
}

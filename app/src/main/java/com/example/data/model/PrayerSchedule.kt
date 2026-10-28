package com.example.data.model

data class PrayerSchedule(
    val dateFormatted: String,
    val cityName: String,
    val latitude: Double,
    val longitude: Double,
    val fajr: String,
    val sunrise: String,
    val dhuhr: String,
    val asr: String,
    val maghrib: String,
    val isha: String,
    val nextPrayerName: String,
    val timeRemainingNextPrayer: String,
    val nextPrayerTimestamp: Long
)

data class CityLocation(
    val name: String,
    val provinceOrCountry: String,
    val latitude: Double,
    val longitude: Double,
    val timezoneHours: Double
)

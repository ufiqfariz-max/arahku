package com.example.prayer.calculation

import com.example.data.model.PrayerSchedule
import java.util.Calendar
import java.util.Locale
import kotlin.math.*

class PrayerTimesCalculator {

    enum class CalculationMethod(val fajrAngle: Double, val ishaAngle: Double) {
        KEMENAG(20.0, 18.0),             // Standar Kementerian Agama Republik Indonesia
        MUSLIM_WORLD_LEAGUE(18.0, 17.0), // Liga Muslim Dunia
        EGYPTIAN(19.5, 17.5),            // Egyptian General Authority of Survey
        UMM_AL_QURA(18.5, 19.0)          // Umm Al-Qura, Makkah
    }

    data class PrayerCalculationResult(
        val fajrTime: Calendar,
        val sunriseTime: Calendar,
        val dhuhrTime: Calendar,
        val asrTime: Calendar,
        val maghribTime: Calendar,
        val ishaTime: Calendar
    )

    fun calculatePrayers(
        latitude: Double,
        longitude: Double,
        timezone: Double,
        calendar: Calendar = Calendar.getInstance(),
        cityName: String = "Lokasi Saya",
        method: CalculationMethod = CalculationMethod.KEMENAG,
        ihtiyatMinutes: Int = 2 // Pengaman waktu shalat standar Kemenag
    ): PrayerSchedule {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // 1. Hitung Julian Day
        val julianDay = calculateJulianDay(year, month, day)

        // 2. Hitung Posisi Matahari (Deklinasi & Equation of Time)
        val d = julianDay - 2451545.0
        val g = fixAngle(357.529 + 0.98560028 * d)
        val q = fixAngle(280.459 + 0.98564736 * d)
        val l = fixAngle(q + 1.915 * sin(Math.toRadians(g)) + 0.020 * sin(Math.toRadians(2 * g)))

        val e = 23.439 - 0.00000036 * d
        val ra = fixAngle(Math.toDegrees(atan2(cos(Math.toRadians(e)) * sin(Math.toRadians(l)), cos(Math.toRadians(l))))) / 15.0
        val declination = Math.toDegrees(asin(sin(Math.toRadians(e)) * sin(Math.toRadians(l))))
        val equationOfTime = q / 15.0 - fixHour(ra)

        // 3. Waktu Dzuhur (Transit Matahari / Zawal)
        val noonTransit = fixHour(12.0 + timezone - (longitude / 15.0) - equationOfTime)

        // 4. Hitung sudut waktu untuk masing-masing waktu shalat
        // Subuh: Depresi matahari sesuai metode (misal 20° Kemenag)
        val fajrDiff = calculateHourAngle(-method.fajrAngle, latitude, declination)
        val fajrHour = noonTransit - (fajrDiff / 15.0)

        // Syuruq (Terbit): Pusat matahari berada pada -0.833°
        val sunriseDiff = calculateHourAngle(-0.833, latitude, declination)
        val sunriseHour = noonTransit - (sunriseDiff / 15.0)

        // Maghrib (Terbenam): -0.833°
        val maghribDiff = sunriseDiff
        val maghribHour = noonTransit + (maghribDiff / 15.0)

        // Ashar: Panjang bayangan = bayangan dzuhur + panjang benda (faktor 1 untuk mazhab Syafi'i/Maliki/Hambali)
        val asrAltitude = Math.toDegrees(atan(1.0 / (1.0 + tan(Math.toRadians(abs(latitude - declination))))))
        val asrDiff = calculateHourAngle(asrAltitude, latitude, declination)
        val asrHour = noonTransit + (asrDiff / 15.0)

        // Isya: Depresi matahari sesuai metode (misal 18° Kemenag)
        val ishaDiff = calculateHourAngle(-method.ishaAngle, latitude, declination)
        val ishaHour = noonTransit + (ishaDiff / 15.0)

        // Buat objek Calendar untuk tiap waktu shalat
        val fajrCal = makeCalendar(calendar, fajrHour, ihtiyatMinutes)
        val sunriseCal = makeCalendar(calendar, sunriseHour, 0)
        val dhuhrCal = makeCalendar(calendar, noonTransit, ihtiyatMinutes)
        val asrCal = makeCalendar(calendar, asrHour, ihtiyatMinutes)
        val maghribCal = makeCalendar(calendar, maghribHour, ihtiyatMinutes)
        val ishaCal = makeCalendar(calendar, ishaHour, ihtiyatMinutes)

        // Tentukan waktu shalat berikutnya dan sisa hitung mundur
        val now = System.currentTimeMillis()
        val prayerTimes = listOf(
            "Subuh" to fajrCal.timeInMillis,
            "Syuruq" to sunriseCal.timeInMillis,
            "Dzuhur" to dhuhrCal.timeInMillis,
            "Ashar" to asrCal.timeInMillis,
            "Maghrib" to maghribCal.timeInMillis,
            "Isya" to ishaCal.timeInMillis
        )

        var nextPrayerName = "Subuh"
        var nextPrayerTimeMs = fajrCal.timeInMillis + 86400000L // default besok

        for (prayer in prayerTimes) {
            if (prayer.second > now) {
                nextPrayerName = prayer.first
                nextPrayerTimeMs = prayer.second
                break
            }
        }

        val diffMs = max(0L, nextPrayerTimeMs - now)
        val hoursRemaining = diffMs / (1000 * 60 * 60)
        val minutesRemaining = (diffMs / (1000 * 60)) % 60
        val secondsRemaining = (diffMs / 1000) % 60
        val countdownStr = String.format(Locale.getDefault(), "%02d:%02d:%02d", hoursRemaining, minutesRemaining, secondsRemaining)

        val dayNames = arrayOf("Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu")
        val monthNames = arrayOf("Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember")
        val dateFormatted = "${dayNames[calendar.get(Calendar.DAY_OF_WEEK) - 1]}, $day ${monthNames[calendar.get(Calendar.MONTH)]} $year"

        return PrayerSchedule(
            dateFormatted = dateFormatted,
            cityName = cityName,
            latitude = latitude,
            longitude = longitude,
            fajr = formatTime(fajrCal),
            sunrise = formatTime(sunriseCal),
            dhuhr = formatTime(dhuhrCal),
            asr = formatTime(asrCal),
            maghrib = formatTime(maghribCal),
            isha = formatTime(ishaCal),
            nextPrayerName = nextPrayerName,
            timeRemainingNextPrayer = countdownStr,
            nextPrayerTimestamp = nextPrayerTimeMs
        )
    }

    private fun calculateHourAngle(altitude: Double, latitude: Double, declination: Double): Double {
        val latRad = Math.toRadians(latitude)
        val decRad = Math.toRadians(declination)
        val altRad = Math.toRadians(altitude)

        val cosH = (sin(altRad) - sin(latRad) * sin(decRad)) / (cos(latRad) * cos(decRad))
        val clampedCosH = cosH.coerceIn(-1.0, 1.0)
        return Math.toDegrees(acos(clampedCosH))
    }

    private fun calculateJulianDay(year: Int, month: Int, day: Int): Double {
        var y = year
        var m = month
        if (m <= 2) {
            y -= 1
            m += 12
        }
        val a = floor(y / 100.0)
        val b = 2 - a + floor(a / 4.0)
        return floor(365.25 * (y + 4716)) + floor(30.6001 * (m + 1)) + day + b - 1524.5
    }

    private fun makeCalendar(base: Calendar, decimalHour: Double, bufferMinutes: Int): Calendar {
        val cal = base.clone() as Calendar
        val totalMinutes = (decimalHour * 60.0).roundToInt() + bufferMinutes
        val normalizedMinutes = (totalMinutes % 1440 + 1440) % 1440
        val hour = normalizedMinutes / 60
        val minute = normalizedMinutes % 60
        cal.set(Calendar.HOUR_OF_DAY, hour)
        cal.set(Calendar.MINUTE, minute)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal
    }

    private fun formatTime(calendar: Calendar): String {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return String.format(Locale.getDefault(), "%02d:%02d", hour, minute)
    }

    private fun fixAngle(angle: Double): Double {
        var a = angle - 360.0 * floor(angle / 360.0)
        if (a < 0) a += 360.0
        return a
    }

    private fun fixHour(hour: Double): Double {
        var h = hour - 24.0 * floor(hour / 24.0)
        if (h < 0) h += 24.0
        return h
    }
}

package com.example.prayer.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.prayer.calculation.LocationProvider
import com.example.prayer.calculation.PrayerTimesCalculator
import com.example.prayer.receiver.AdhanAlarmReceiver
import java.util.Calendar

class AdhanAlarmScheduler(private val context: Context) {

    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    private val calculator = PrayerTimesCalculator()

    fun scheduleNextPrayerAlarm(
        latitude: Double = LocationProvider.defaultCity.latitude,
        longitude: Double = LocationProvider.defaultCity.longitude,
        timezone: Double = LocationProvider.defaultCity.timezoneHours,
        cityName: String = LocationProvider.defaultCity.name
    ) {
        val now = System.currentTimeMillis()
        val calendar = Calendar.getInstance()
        val schedule = calculator.calculatePrayers(latitude, longitude, timezone, calendar, cityName)

        var triggerTime = schedule.nextPrayerTimestamp
        var prayerName = schedule.nextPrayerName

        // Jika semua shalat hari ini sudah lewat, jadwalkan Subuh esok hari
        if (triggerTime <= now) {
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            val tomorrowSchedule = calculator.calculatePrayers(latitude, longitude, timezone, calendar, cityName)
            triggerTime = tomorrowSchedule.nextPrayerTimestamp
            prayerName = tomorrowSchedule.nextPrayerName
        }

        val intent = Intent(context, AdhanAlarmReceiver::class.java).apply {
            action = "com.example.ACTION_ADHAN_ALARM"
            putExtra(AdhanAlarmReceiver.EXTRA_PRAYER_NAME, prayerName)
            putExtra(AdhanAlarmReceiver.EXTRA_CITY_NAME, cityName)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            ALARM_REQUEST_CODE,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    triggerTime,
                    pendingIntent
                )
            } else {
                alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    triggerTime,
                    pendingIntent
                )
            }
        } catch (e: SecurityException) {
            // Pada Android 12+, jika izin SCHEDULE_EXACT_ALARM dicabut, gunakan set
            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                pendingIntent
            )
        }
    }

    fun cancelAlarm() {
        val intent = Intent(context, AdhanAlarmReceiver::class.java).apply {
            action = "com.example.ACTION_ADHAN_ALARM"
        }
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            ALARM_REQUEST_CODE,
            intent,
            PendingIntent.FLAG_NO_CREATE or PendingIntent.FLAG_IMMUTABLE
        )
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent)
            pendingIntent.cancel()
        }
    }

    companion object {
        private const val ALARM_REQUEST_CODE = 9901
    }
}

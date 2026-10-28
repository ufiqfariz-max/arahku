package com.example.prayer.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.prayer.alarm.AdhanAlarmScheduler

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED ||
            intent.action == "android.intent.action.QUICKBOOT_POWERON"
        ) {
            // Pasca reboot perangkat, jadwalkan kembali alarm waktu shalat
            AdhanAlarmScheduler(context).scheduleNextPrayerAlarm()
        }
    }
}

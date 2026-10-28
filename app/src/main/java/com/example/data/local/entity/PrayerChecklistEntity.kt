package com.example.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_prayer_checklist")
data class PrayerChecklistEntity(
    @PrimaryKey
    @ColumnInfo(name = "date")
    val date: String, // Format: yyyy-MM-dd

    // Shalat Wajib
    @ColumnInfo(name = "fajr")
    val fajr: Boolean = false,

    @ColumnInfo(name = "dhuhr")
    val dhuhr: Boolean = false,

    @ColumnInfo(name = "asr")
    val asr: Boolean = false,

    @ColumnInfo(name = "maghrib")
    val maghrib: Boolean = false,

    @ColumnInfo(name = "isha")
    val isha: Boolean = false,

    // Shalat Sunnah
    @ColumnInfo(name = "tahajjud")
    val tahajjud: Boolean = false,

    @ColumnInfo(name = "dhuha")
    val dhuha: Boolean = false,

    @ColumnInfo(name = "rawatib")
    val rawatib: Boolean = false,

    @ColumnInfo(name = "witir")
    val witir: Boolean = false,

    // Amalan Tambahan
    @ColumnInfo(name = "quran_pages")
    val quranPages: Int = 0,

    @ColumnInfo(name = "dhikr_done")
    val dhikrDone: Boolean = false,

    @ColumnInfo(name = "notes")
    val notes: String = ""
) {
    fun completedFardhuCount(): Int {
        var count = 0
        if (fajr) count++
        if (dhuhr) count++
        if (asr) count++
        if (maghrib) count++
        if (isha) count++
        return count
    }

    fun completedSunnahCount(): Int {
        var count = 0
        if (tahajjud) count++
        if (dhuha) count++
        if (rawatib) count++
        if (witir) count++
        return count
    }
}

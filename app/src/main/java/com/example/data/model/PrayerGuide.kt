package com.example.data.model

enum class PrayerGuideCategory(val displayName: String) {
    SYARAT_RUKUN("Syarat & Rukun"),
    NIAT_5_WAKTU("Niat Shalat 5 Waktu"),
    TATA_CARA("Tata Cara & Bacaan"),
    DZIKIR_SESUDAH("Dzikir & Doa Shalat")
}

enum class PrayerTimeType(val displayName: String) {
    ALL("Semua"),
    SUBUH("Subuh (2 Rakaat)"),
    DZUHUR("Dzuhur (4 Rakaat)"),
    ASHAR("Ashar (4 Rakaat)"),
    MAGHRIB("Maghrib (3 Rakaat)"),
    ISYA("Isya (4 Rakaat)")
}

enum class PrayerRole(val displayName: String) {
    ALL("Semua Posisi"),
    MUNFARID("Sendiri (Munfarid)"),
    MAKMUM("Makmum"),
    IMAM("Imam")
}

data class PrayerGuideItem(
    val id: String,
    val category: PrayerGuideCategory,
    val title: String,
    val subtitle: String = "",
    val stepNumber: Int? = null,
    val prayerTime: PrayerTimeType? = null,
    val role: PrayerRole? = null,
    val arabic: String = "",
    val latin: String = "",
    val translation: String = "",
    val explanation: String = "",
    val rakaat: Int? = null,
    val sourceUrl: String = "https://mozaik.inilah.com/ibadah/bacaan-sholat-5-waktu-lengkap",
    val sourceName: String = "Mozaik Inilah.com"
)

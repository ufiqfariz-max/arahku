package com.example.data.model

enum class DzikirType(val displayName: String) {
    PAGI("Dzikir Pagi"),
    PETANG("Dzikir Petang"),
    SEBELUM_TIDUR("Sebelum Tidur")
}

data class DzikirItem(
    val id: Int,
    val type: DzikirType,
    val title: String,
    val arabic: String,
    val latin: String,
    val translation: String,
    val targetCount: Int = 1,
    val fadhilah: String = "",
    val source: String = "Al-Qur'an & As-Sunnah (Shahih)"
)

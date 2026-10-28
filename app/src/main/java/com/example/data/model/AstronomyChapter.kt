package com.example.data.model

data class AstronomySection(
    val title: String,
    val explanation: String,
    val keyPoints: List<String> = emptyList(),
    val formulaOrFacts: String = ""
)

data class AstronomyChapter(
    val id: Int,
    val number: String,
    val title: String,
    val category: String,
    val summary: String,
    val sections: List<AstronomySection>,
    val tags: List<String> = emptyList()
)

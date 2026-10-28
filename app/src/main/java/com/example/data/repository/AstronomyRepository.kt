package com.example.data.repository

import android.content.Context
import com.example.data.model.AstronomyChapter
import com.example.data.model.AstronomySection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray

/**
 * Repository untuk memuat materi Buku Astronomi dari assets/buku_astronomi.json secara offline.
 * Referensi: https://www.scribd.com/document/378991675/Buku-Astronomi
 */
class AstronomyRepository(private val context: Context) {

    suspend fun loadChapters(): List<AstronomyChapter> = withContext(Dispatchers.IO) {
        try {
            val jsonString = context.assets.open("buku_astronomi.json")
                .bufferedReader()
                .use { it.readText() }

            val jsonArray = JSONArray(jsonString)
            val chapters = mutableListOf<AstronomyChapter>()

            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val sectionsArray = obj.optJSONArray("sections")
                val sections = mutableListOf<AstronomySection>()
                if (sectionsArray != null) {
                    for (s in 0 until sectionsArray.length()) {
                        val secObj = sectionsArray.getJSONObject(s)
                        val kpArray = secObj.optJSONArray("keyPoints")
                        val keyPoints = mutableListOf<String>()
                        if (kpArray != null) {
                            for (k in 0 until kpArray.length()) {
                                keyPoints.add(kpArray.getString(k))
                            }
                        }
                        sections.add(
                            AstronomySection(
                                title = secObj.getString("title"),
                                explanation = secObj.getString("explanation"),
                                keyPoints = keyPoints,
                                formulaOrFacts = secObj.optString("formulaOrFacts", "")
                            )
                        )
                    }
                }

                val tagsArray = obj.optJSONArray("tags")
                val tags = mutableListOf<String>()
                if (tagsArray != null) {
                    for (t in 0 until tagsArray.length()) {
                        tags.add(tagsArray.getString(t))
                    }
                }

                chapters.add(
                    AstronomyChapter(
                        id = obj.getInt("id"),
                        number = obj.getString("number"),
                        title = obj.getString("title"),
                        category = obj.getString("category"),
                        summary = obj.getString("summary"),
                        sections = sections,
                        tags = tags
                    )
                )
            }
            chapters
        } catch (e: Exception) {
            emptyList()
        }
    }
}

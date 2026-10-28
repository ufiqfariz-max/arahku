package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.prayer.calculation.PrayerTimesCalculator
import com.example.qibla.calculation.QiblaCalculator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.Calendar

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Arahku", appName)
    }

    @Test
    fun `qibla calculation for Jakarta is approximately 295 degrees`() {
        val jakartaLat = -6.2088
        val jakartaLng = 106.8456
        val bearing = QiblaCalculator.calculateQiblaBearing(jakartaLat, jakartaLng)
        // Jakarta Qibla azimuth is ~295°
        assertTrue("Bearing should be near 295, but was $bearing", bearing in 294.0f..296.5f)

        val distance = QiblaCalculator.calculateDistanceToKaabaKm(jakartaLat, jakartaLng)
        assertTrue("Distance should be ~7900 km, but was $distance", distance in 7500.0..8200.0)
    }

    @Test
    fun `prayer times calculator generates valid schedule`() {
        val calculator = PrayerTimesCalculator()
        val calendar = Calendar.getInstance().apply {
            set(2026, Calendar.OCTOBER, 28)
        }
        val schedule = calculator.calculatePrayers(
            latitude = -6.2088,
            longitude = 106.8456,
            timezone = 7.0,
            calendar = calendar,
            cityName = "DKI Jakarta"
        )

        assertTrue(schedule.fajr.isNotBlank())
        assertTrue(schedule.dhuhr.isNotBlank())
        assertTrue(schedule.asr.isNotBlank())
        assertTrue(schedule.maghrib.isNotBlank())
        assertTrue(schedule.isha.isNotBlank())
    }

    @Test
    fun `dzikir data contains pagi, petang, and sebelum tidur with proper content`() {
        val allDzikir = com.example.data.local.DzikirAlRabiahData.dzikirList
        assertTrue("Dzikir list should not be empty", allDzikir.isNotEmpty())

        val pagiList = allDzikir.filter { it.type == com.example.data.model.DzikirType.PAGI }
        val petangList = allDzikir.filter { it.type == com.example.data.model.DzikirType.PETANG }
        val tidurList = allDzikir.filter { it.type == com.example.data.model.DzikirType.SEBELUM_TIDUR }

        assertTrue("Should have dzikir pagi", pagiList.isNotEmpty())
        assertTrue("Should have dzikir petang", petangList.isNotEmpty())
        assertTrue("Should have dzikir sebelum tidur", tidurList.isNotEmpty())

        allDzikir.forEach { item ->
            assertTrue(item.title.isNotBlank())
            assertTrue(item.arabic.isNotBlank())
            assertTrue(item.latin.isNotBlank())
            assertTrue(item.translation.isNotBlank())
            assertTrue(item.targetCount > 0)
            assertTrue("Source should reference Al-Qur'an & As-Sunnah", item.source.contains("Al-Qur'an & As-Sunnah"))
        }
    }

    @Test
    fun `astronomy repository loads all 12 chapters from assets`() = kotlinx.coroutines.runBlocking {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val repository = com.example.data.repository.AstronomyRepository(context)
        val chapters = repository.loadChapters()

        assertTrue("Should load astronomy chapters", chapters.isNotEmpty())
        assertEquals("Should have all 12 chapters", 12, chapters.size)
        val bab1 = chapters.first()
        assertEquals("BAB 1", bab1.number)
        assertTrue(bab1.sections.isNotEmpty())

        val bab12 = chapters.last()
        assertEquals("BAB 12", bab12.number)
        assertTrue(bab12.sections.isNotEmpty())
        assertEquals("Eksoplanet, Astrobiologi & Kehidupan Ekstraterestrial", bab12.title)
    }

    @Test
    fun `prayer guide data contains complete items with mozaik inilah reference`() {
        val items = com.example.data.local.PrayerGuideData.items
        assertTrue("Prayer guide items should not be empty", items.isNotEmpty())

        val syaratRukun = items.filter { it.category == com.example.data.model.PrayerGuideCategory.SYARAT_RUKUN }
        val niat = items.filter { it.category == com.example.data.model.PrayerGuideCategory.NIAT_5_WAKTU }
        val tataCara = items.filter { it.category == com.example.data.model.PrayerGuideCategory.TATA_CARA }
        val dzikir = items.filter { it.category == com.example.data.model.PrayerGuideCategory.DZIKIR_SESUDAH }

        assertTrue("Should have syarat & rukun", syaratRukun.isNotEmpty())
        assertTrue("Should have niat 5 waktu", niat.isNotEmpty())
        assertTrue("Should have tata cara gerakan", tataCara.isNotEmpty())
        assertTrue("Should have dzikir sesudah shalat", dzikir.isNotEmpty())

        items.forEach { item ->
            assertTrue(item.title.isNotBlank())
            assertTrue(item.sourceUrl.contains("https://mozaik.inilah.com/ibadah/bacaan-sholat-5-waktu-lengkap"))
            assertTrue(item.sourceName.contains("Inilah.com"))
        }

        val viewModel = com.example.viewmodel.PrayerGuideViewModel()
        viewModel.selectCategory(com.example.data.model.PrayerGuideCategory.NIAT_5_WAKTU)
        viewModel.selectPrayerTime(com.example.data.model.PrayerTimeType.SUBUH)
        val filtered = viewModel.filteredItems.value
        assertTrue("Filtered subuh niat should have items", filtered.isNotEmpty())
    }
}

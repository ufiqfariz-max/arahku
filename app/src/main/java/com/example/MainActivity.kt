package com.example

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.AppBottomNav
import com.example.ui.components.ScreenTab
import com.example.ui.screens.*
import com.example.ui.theme.MyApplicationTheme
import com.example.viewmodel.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                ArahkuApp()
            }
        }
    }
}

@Composable
fun AshSholahApp() {
    ArahkuApp()
}

@Composable
fun ArahkuApp() {
    var currentTab by rememberSaveable { mutableStateOf(ScreenTab.PRAYER) }

    val prayerViewModel: PrayerViewModel = viewModel()
    val prayerGuideViewModel: PrayerGuideViewModel = viewModel()
    val qiblaViewModel: QiblaViewModel = viewModel()
    val dzikirViewModel: DzikirViewModel = viewModel()
    val doaViewModel: DoaViewModel = viewModel()
    val astronomyViewModel: AstronomyViewModel = viewModel()
    val trackerViewModel: TrackerViewModel = viewModel()

    // Request notification permission for Android 13+ (TIRAMISU)
    val notificationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { /* Permission result handled */ }

    // Location permission launcher (optional GPS enhancement)
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        if (granted) {
            // Optional GPS location can update ViewModel if needed
        }
    }

    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    // BackHandler: Return to Prayer tab before exiting app
    BackHandler(enabled = currentTab != ScreenTab.PRAYER) {
        currentTab = ScreenTab.PRAYER
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AppBottomNav(
                currentTab = currentTab,
                onTabSelected = { currentTab = it }
            )
        }
    ) { innerPadding ->
        val contentModifier = Modifier
            .fillMaxSize()
            .padding(bottom = innerPadding.calculateBottomPadding())

        when (currentTab) {
            ScreenTab.PRAYER -> PrayerScreen(
                viewModel = prayerViewModel,
                trackerViewModel = trackerViewModel,
                onNavigateToGuide = { currentTab = ScreenTab.GUIDE },
                modifier = contentModifier
            )
            ScreenTab.GUIDE -> PrayerGuideScreen(
                viewModel = prayerGuideViewModel,
                modifier = contentModifier
            )
            ScreenTab.QIBLA -> QiblaScreen(
                viewModel = qiblaViewModel,
                modifier = contentModifier
            )
            ScreenTab.DZIKIR -> DzikirScreen(
                viewModel = dzikirViewModel,
                modifier = contentModifier
            )
            ScreenTab.DOA -> DoaScreen(
                viewModel = doaViewModel,
                modifier = contentModifier
            )
            ScreenTab.ASTRONOMY -> AstronomyScreen(
                viewModel = astronomyViewModel,
                modifier = contentModifier
            )
        }
    }
}

package com.example.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.QiblaData
import com.example.viewmodel.QiblaViewModel
import kotlin.math.cos
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QiblaScreen(
    viewModel: QiblaViewModel,
    modifier: Modifier = Modifier
) {
    val qiblaData by viewModel.qiblaData.collectAsState()
    val isTilted by viewModel.isTilted.collectAsState()
    val hasSensors by viewModel.hasSensors.collectAsState()
    val currentCity by viewModel.currentCity.collectAsState()
    var showCityDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Arah Kiblat",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Text(
                                    text = "UIN Jakarta",
                                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = "Arah Ka'bah Presisi • Prodi Tadris Fisika UIN Jakarta",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { showCityDialog = true }) {
                        Icon(
                            imageVector = Icons.Default.LocationCity,
                            contentDescription = "Pilih Kota Indonesia",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            // Location Header
            item {
                Card(
                    onClick = { showCityDialog = true },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Place,
                                contentDescription = "Lokasi",
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Column {
                                Text(
                                    text = currentCity.name,
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold)
                                )
                                Text(
                                    text = "Sudut Azimut: ${String.format("%.1f", qiblaData.qiblaBearing)}° dari Utara",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Text(
                                text = "${String.format("%.0f", qiblaData.distanceKm)} km",
                                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }

            // Tilt Warning if tilted
            if (isTilted) {
                item {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = "Peringatan",
                                tint = MaterialTheme.colorScheme.onErrorContainer
                            )
                            Text(
                                text = "Letakkan ponsel mendatar di permukaan datar untuk kompas yang lebih akurat.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                        }
                    }
                }
            }

            // Alignment Status Pill
            item {
                val statusBgColor by animateColorAsState(
                    targetValue = if (qiblaData.isFacingQibla)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.surfaceVariant,
                    label = "statusBg"
                )
                val statusTextColor by animateColorAsState(
                    targetValue = if (qiblaData.isFacingQibla)
                        MaterialTheme.colorScheme.onPrimary
                    else
                        MaterialTheme.colorScheme.onSurfaceVariant,
                    label = "statusText"
                )

                Surface(
                    shape = RoundedCornerShape(50),
                    color = statusBgColor,
                    modifier = Modifier.testTag("status_facing_qibla")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = if (qiblaData.isFacingQibla) Icons.Default.CheckCircle else Icons.Default.Explore,
                            contentDescription = "Status",
                            tint = statusTextColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = if (qiblaData.isFacingQibla)
                                "Tepat Menghadap Ka'bah (Kiblat)!"
                            else
                                "Putar ponsel hingga jarum emas ke atas",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            color = statusTextColor
                        )
                    }
                }
            }

            // Interactive Compass Dial
            item {
                Box(
                    modifier = Modifier
                        .size(310.dp)
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Compass Dial
                    CompassDialCanvas(
                        deviceAzimuth = qiblaData.deviceAzimuth,
                        qiblaBearing = qiblaData.qiblaBearing,
                        isFacingQibla = qiblaData.isFacingQibla,
                        modifier = Modifier.fillMaxSize()
                    )

                    // Center Kaaba Emblem
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(
                                if (qiblaData.isFacingQibla)
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.surfaceVariant
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Mosque,
                            contentDescription = "Ka'bah",
                            tint = if (qiblaData.isFacingQibla)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }

            // Azimuth Readout
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "${String.format("%.1f", qiblaData.deviceAzimuth)}°",
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = "Arah Ponsel (${getCompassHeadingText(qiblaData.deviceAzimuth)})",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Info Card (Great-Circle Distance formula)
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Navigation,
                                contentDescription = "Trigonometri",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Trigonometri Bola Ka'bah",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                            )
                        }
                        Text(
                            text = "Ka'bah Makkah: 21° 25' 21\" LU, 39° 49' 34\" BT.\nFormula Great-Circle Bearing menghitung sudut busur terpendek pada elipsoid bumi secara presisi 100% tanpa internet.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "Status Sensor: ${qiblaData.accuracy}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }

            // Panduan Kalibrasi & Sensitivitas Sensor
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AllInclusive,
                                contentDescription = "Kalibrasi",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Tips Meningkatkan Sensitivitas Kompas",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        Text(
                            text = "• Kalibrasi Angka 8: Gerakkan ponsel membentuk pola angka 8 di udara selama 3-5 detik jika jarum terasa kaku atau lambat berputar.\n• Bebaskan dari Magnet: Jauhkan dari casing magnetik, powerbank, atau permukaan logam tebal.\n• Posisi Datar: Pegang ponsel mendatar setinggi dada untuk pembacaan sudut paling sensitif dan akurat.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }

    if (showCityDialog) {
        CitySelectionDialog(
            cities = viewModel.availableCities,
            currentCity = currentCity,
            onSelect = { city ->
                viewModel.updateLocation(city)
                showCityDialog = false
            },
            onDismiss = { showCityDialog = false }
        )
    }
}

@Composable
fun CompassDialCanvas(
    deviceAzimuth: Float,
    qiblaBearing: Float,
    isFacingQibla: Boolean,
    modifier: Modifier = Modifier
) {
    // Unwrapped continuous azimuth calculation to prevent 360-degree reverse spin
    var lastTarget by remember { mutableFloatStateOf(deviceAzimuth) }
    var unwrappedAzimuth by remember { mutableFloatStateOf(deviceAzimuth) }

    LaunchedEffect(deviceAzimuth) {
        var diff = (deviceAzimuth - lastTarget) % 360f
        if (diff > 180f) diff -= 360f
        if (diff < -180f) diff += 360f
        unwrappedAzimuth += diff
        lastTarget = deviceAzimuth
    }

    // High stiffness (800f) and optimal damping (0.7f) for ultra-sensitive, lag-free response
    val animatedAzimuth by animateFloatAsState(
        targetValue = unwrappedAzimuth,
        animationSpec = spring(dampingRatio = 0.70f, stiffness = 850f),
        label = "azimuthAnim"
    )

    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val surfaceColor = MaterialTheme.colorScheme.surface
    val surfaceVariantColor = MaterialTheme.colorScheme.surfaceVariant
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface
    val onSurfaceVariantColor = MaterialTheme.colorScheme.onSurfaceVariant

    Canvas(modifier = modifier) {
        val center = Offset(size.width / 2, size.height / 2)
        val radius = size.minDimension / 2 - 12.dp.toPx()

        // Background Circle Outer Rim
        drawCircle(
            color = surfaceVariantColor.copy(alpha = 0.4f),
            radius = radius + 8.dp.toPx(),
            center = center
        )
        drawCircle(
            color = surfaceColor,
            radius = radius,
            center = center
        )
        drawCircle(
            color = if (isFacingQibla) primaryColor else surfaceVariantColor,
            radius = radius,
            center = center,
            style = Stroke(width = if (isFacingQibla) 6.dp.toPx() else 2.dp.toPx())
        )

        // Rotate canvas according to deviceAzimuth
        rotate(degrees = -animatedAzimuth, pivot = center) {
            // Degree marks (every 10 degrees)
            for (angle in 0 until 360 step 10) {
                val angleRad = Math.toRadians(angle.toDouble())
                val isMajor = angle % 30 == 0
                val tickLength = if (isMajor) 14.dp.toPx() else 7.dp.toPx()
                val tickWidth = if (isMajor) 2.dp.toPx() else 1.dp.toPx()

                val outerX = center.x + radius * sin(angleRad).toFloat()
                val outerY = center.y - radius * cos(angleRad).toFloat()
                val innerX = center.x + (radius - tickLength) * sin(angleRad).toFloat()
                val innerY = center.y - (radius - tickLength) * cos(angleRad).toFloat()

                drawLine(
                    color = if (angle == 0) Color.Red else onSurfaceVariantColor.copy(alpha = 0.7f),
                    start = Offset(innerX, innerY),
                    end = Offset(outerX, outerY),
                    strokeWidth = tickWidth
                )
            }

            // North Pointer (Red triangle)
            val northPath = Path().apply {
                moveTo(center.x, center.y - radius + 18.dp.toPx())
                lineTo(center.x - 8.dp.toPx(), center.y - radius + 32.dp.toPx())
                lineTo(center.x + 8.dp.toPx(), center.y - radius + 32.dp.toPx())
                close()
            }
            drawPath(northPath, color = Color.Red)

            // Qibla Indicator Needle (Golden Arrow towards Kaaba)
            rotate(degrees = qiblaBearing, pivot = center) {
                val qiblaPath = Path().apply {
                    moveTo(center.x, center.y - radius + 4.dp.toPx())
                    lineTo(center.x - 12.dp.toPx(), center.y - radius + 28.dp.toPx())
                    lineTo(center.x + 12.dp.toPx(), center.y - radius + 28.dp.toPx())
                    close()
                }
                drawPath(qiblaPath, color = secondaryColor)

                // Line connecting to center
                drawLine(
                    color = secondaryColor,
                    start = Offset(center.x, center.y - 36.dp.toPx()),
                    end = Offset(center.x, center.y - radius + 28.dp.toPx()),
                    strokeWidth = 3.dp.toPx()
                )
            }
        }
    }
}

fun getCompassHeadingText(azimuth: Float): String {
    return when ((azimuth + 22.5f) % 360f) {
        in 0f..45f -> "Utara"
        in 45f..90f -> "Timur Laut"
        in 90f..135f -> "Timur"
        in 135f..180f -> "Tenggara"
        in 180f..225f -> "Selatan"
        in 225f..270f -> "Barat Daya"
        in 270f..315f -> "Barat"
        in 315f..360f -> "Barat Laut"
        else -> "Utara"
    }
}

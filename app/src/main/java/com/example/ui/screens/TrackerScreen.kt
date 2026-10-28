package com.example.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.entity.PrayerChecklistEntity
import com.example.viewmodel.TrackerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackerScreen(
    viewModel: TrackerViewModel,
    modifier: Modifier = Modifier
) {
    val currentChecklist by viewModel.currentChecklist.collectAsState()
    val recentHistory by viewModel.recentChecklists.collectAsState()
    val selectedDate by viewModel.selectedDate.collectAsState()

    val completedFardhu = currentChecklist.completedFardhuCount()
    val completedSunnah = currentChecklist.completedSunnahCount()
    val fardhuPercentage = (completedFardhu / 5f)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Tracker Ibadah Harian",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text = "Database Room Offline • Shalat Wajib & Sunnah",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            // Today's Progress Summary Hero Card
            item {
                Card(
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("tracker_progress_card")
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = if (selectedDate == viewModel.todayDateString) "Hari Ini" else selectedDate,
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Shalat Wajib: $completedFardhu / 5",
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .size(54.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primary),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${(fardhuPercentage * 100).toInt()}%",
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }

                        LinearProgressIndicator(
                            progress = { fardhuPercentage },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = MaterialTheme.colorScheme.primary,
                            trackColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Sunnah: $completedSunnah amalan terlaksana",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                            )
                            if (currentChecklist.quranPages > 0) {
                                Text(
                                    text = "${currentChecklist.quranPages} Halaman Tilawah",
                                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }

            // Section 1: Shalat Wajib (5 Waktu)
            item {
                Text(
                    text = "Shalat Fardhu (Wajib)",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(vertical = 4.dp)) {
                        ChecklistRow(
                            title = "Subuh",
                            subtitle = "2 Rakaat • Fajar Shadiq",
                            icon = Icons.Default.WbTwilight,
                            isChecked = currentChecklist.fajr,
                            onToggle = { viewModel.toggleFajr() },
                            testTag = "check_subuh"
                        )
                        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        ChecklistRow(
                            title = "Dzuhur",
                            subtitle = "4 Rakaat • Pasca Zawal",
                            icon = Icons.Default.LightMode,
                            isChecked = currentChecklist.dhuhr,
                            onToggle = { viewModel.toggleDhuhr() },
                            testTag = "check_dzuhur"
                        )
                        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        ChecklistRow(
                            title = "Ashar",
                            subtitle = "4 Rakaat • Bayangan 1x",
                            icon = Icons.Default.BrightnessMedium,
                            isChecked = currentChecklist.asr,
                            onToggle = { viewModel.toggleAsr() },
                            testTag = "check_ashar"
                        )
                        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        ChecklistRow(
                            title = "Maghrib",
                            subtitle = "3 Rakaat • Ghurub Matahari",
                            icon = Icons.Default.NightsStay,
                            isChecked = currentChecklist.maghrib,
                            onToggle = { viewModel.toggleMaghrib() },
                            testTag = "check_maghrib"
                        )
                        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        ChecklistRow(
                            title = "Isya",
                            subtitle = "4 Rakaat • Hilang Syafaq",
                            icon = Icons.Default.Bedtime,
                            isChecked = currentChecklist.isha,
                            onToggle = { viewModel.toggleIsha() },
                            testTag = "check_isya"
                        )
                    }
                }
            }

            // Section 2: Shalat Sunnah
            item {
                Text(
                    text = "Shalat Sunnah Muakkad & Nawafil",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(vertical = 4.dp)) {
                        ChecklistRow(
                            title = "Tahajjud / Qiyamul Lail",
                            subtitle = "Shalat Malam & Istighfar Sepertiga Malam",
                            icon = Icons.Default.Brightness3,
                            isChecked = currentChecklist.tahajjud,
                            onToggle = { viewModel.toggleTahajjud() },
                            testTag = "check_tahajjud"
                        )
                        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        ChecklistRow(
                            title = "Dhuha",
                            subtitle = "2–8 Rakaat di Pagi Hari",
                            icon = Icons.Default.WbSunny,
                            isChecked = currentChecklist.dhuha,
                            onToggle = { viewModel.toggleDhuha() },
                            testTag = "check_dhuha"
                        )
                        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        ChecklistRow(
                            title = "Sunnah Rawatib",
                            subtitle = "Qabliyah & Ba'diyah Fardhu",
                            icon = Icons.Default.Favorite,
                            isChecked = currentChecklist.rawatib,
                            onToggle = { viewModel.toggleRawatib() },
                            testTag = "check_rawatib"
                        )
                        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        ChecklistRow(
                            title = "Witir",
                            subtitle = "Penutup Shalat Malam Ganjil",
                            icon = Icons.Default.Star,
                            isChecked = currentChecklist.witir,
                            onToggle = { viewModel.toggleWitir() },
                            testTag = "check_witir"
                        )
                    }
                }
            }

            // Section 3: Amalan Harian Tambahan
            item {
                Text(
                    text = "Amalan Harian Tambahan",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        // Tilawah Counter
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "Tilawah Al-Qur'an",
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold)
                                )
                                Text(
                                    text = "${currentChecklist.quranPages} Halaman Hari Ini",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                FilledTonalIconButton(
                                    onClick = { viewModel.decrementQuranPages() },
                                    enabled = currentChecklist.quranPages > 0
                                ) {
                                    Icon(Icons.Default.Remove, contentDescription = "Kurang")
                                }
                                Text(
                                    text = "${currentChecklist.quranPages}",
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    modifier = Modifier.widthIn(min = 24.dp)
                                )
                                FilledTonalIconButton(
                                    onClick = { viewModel.incrementQuranPages() }
                                ) {
                                    Icon(Icons.Default.Add, contentDescription = "Tambah")
                                }
                            }
                        }

                        HorizontalDivider()

                        // Dzikir Switch
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "Dzikir Pagi & Petang",
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold)
                                )
                                Text(
                                    text = "Al-Ma'tsurat / Wirid Perlindungan",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Switch(
                                checked = currentChecklist.dhikrDone,
                                onCheckedChange = { viewModel.toggleDhikr() }
                            )
                        }
                    }
                }
            }

            // History Section
            if (recentHistory.isNotEmpty()) {
                item {
                    Text(
                        text = "Riwayat Catatan Tersimpan (Room DB)",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }

                items(recentHistory) { history ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (history.date == selectedDate)
                                MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
                            else
                                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.selectDate(history.date) }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp, vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = history.date,
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
                                )
                                Text(
                                    text = "Wajib: ${history.completedFardhuCount()}/5 • Sunnah: ${history.completedSunnahCount()}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (history.completedFardhuCount() == 5)
                                    MaterialTheme.colorScheme.primaryContainer
                                else
                                    MaterialTheme.colorScheme.surfaceVariant
                            ) {
                                Text(
                                    text = if (history.completedFardhuCount() == 5) "Lengkap" else "Sebagian",
                                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                    color = if (history.completedFardhuCount() == 5)
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                    else
                                        MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ChecklistRow(
    title: String,
    subtitle: String,
    icon: ImageVector,
    isChecked: Boolean,
    onToggle: () -> Unit,
    testTag: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onToggle() }
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .testTag(testTag),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(
                        if (isChecked)
                            MaterialTheme.colorScheme.primaryContainer
                        else
                            MaterialTheme.colorScheme.surfaceVariant
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = if (isChecked)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(20.dp)
                )
            }

            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Checkbox(
            checked = isChecked,
            onCheckedChange = { onToggle() },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                checkmarkColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    }
}

package com.example.qibla.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlin.math.abs

/**
 * Manajer Sensor Kompas dengan Sensor Fusion berkecepatan tinggi.
 * Mengutamakan TYPE_ROTATION_VECTOR untuk kepekaan arah yang sangat responsif,
 * dengan fallback ke Akselerometer + Magnetometer adaptif.
 */
class CompassSensorManager(context: Context) {

    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val rotationVector: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
    private val accelerometer: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    private val magnetometer: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

    data class CompassSensorData(
        val azimuthDegrees: Float,
        val accuracyText: String,
        val isTilted: Boolean, // True jika hp miring > 45 derajat
        val hasSensors: Boolean,
        val sensorType: String
    )

    fun getCompassDataFlow(): Flow<CompassSensorData> = callbackFlow {
        val hasRotationVector = rotationVector != null
        val hasLegacySensors = accelerometer != null && magnetometer != null

        if (!hasRotationVector && !hasLegacySensors) {
            trySend(
                CompassSensorData(
                    azimuthDegrees = 0f,
                    accuracyText = "Sensor Magnetik Tidak Tersedia",
                    isTilted = false,
                    hasSensors = false,
                    sensorType = "None"
                )
            )
            close()
            return@callbackFlow
        }

        val rotationMatrix = FloatArray(9)
        val orientationAngles = FloatArray(3)
        var currentAccuracyText = "Akurasi Tinggi"

        // State untuk fallback sensor
        val gravity = FloatArray(3)
        val geomagnetic = FloatArray(3)
        var hasGravity = false
        var hasGeomagnetic = false

        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                when (event.sensor.type) {
                    Sensor.TYPE_ROTATION_VECTOR -> {
                        // Sensor Fusi Resmi Android (Gyro + Accel + Mag) - Sangat Sensitif & Akurat
                        SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values)
                        SensorManager.getOrientation(rotationMatrix, orientationAngles)

                        val azimuthRad = orientationAngles[0]
                        val pitchRad = orientationAngles[1]
                        val rollRad = orientationAngles[2]

                        var azimuthDeg = Math.toDegrees(azimuthRad.toDouble()).toFloat()
                        azimuthDeg = (azimuthDeg + 360f) % 360f

                        val pitchDeg = Math.toDegrees(pitchRad.toDouble()).toFloat()
                        val rollDeg = Math.toDegrees(rollRad.toDouble()).toFloat()
                        val isTilted = abs(pitchDeg) > 45f || abs(rollDeg) > 45f

                        trySend(
                            CompassSensorData(
                                azimuthDegrees = azimuthDeg,
                                accuracyText = currentAccuracyText,
                                isTilted = isTilted,
                                hasSensors = true,
                                sensorType = "Rotation Vector (Hardware Fused)"
                            )
                        )
                    }

                    Sensor.TYPE_ACCELEROMETER -> {
                        // Filter dinamis yang jauh lebih responsif (alpha = 0.45)
                        val alpha = 0.45f
                        gravity[0] = gravity[0] + alpha * (event.values[0] - gravity[0])
                        gravity[1] = gravity[1] + alpha * (event.values[1] - gravity[1])
                        gravity[2] = gravity[2] + alpha * (event.values[2] - gravity[2])
                        hasGravity = true
                        calculateLegacyOrientation()
                    }

                    Sensor.TYPE_MAGNETIC_FIELD -> {
                        val alpha = 0.45f
                        geomagnetic[0] = geomagnetic[0] + alpha * (event.values[0] - geomagnetic[0])
                        geomagnetic[1] = geomagnetic[1] + alpha * (event.values[1] - geomagnetic[1])
                        geomagnetic[2] = geomagnetic[2] + alpha * (event.values[2] - geomagnetic[2])
                        hasGeomagnetic = true
                        calculateLegacyOrientation()
                    }
                }
            }

            private fun calculateLegacyOrientation() {
                if (hasGravity && hasGeomagnetic) {
                    val success = SensorManager.getRotationMatrix(rotationMatrix, null, gravity, geomagnetic)
                    if (success) {
                        SensorManager.getOrientation(rotationMatrix, orientationAngles)

                        val azimuthRad = orientationAngles[0]
                        val pitchRad = orientationAngles[1]
                        val rollRad = orientationAngles[2]

                        var azimuthDeg = Math.toDegrees(azimuthRad.toDouble()).toFloat()
                        azimuthDeg = (azimuthDeg + 360f) % 360f

                        val pitchDeg = Math.toDegrees(pitchRad.toDouble()).toFloat()
                        val rollDeg = Math.toDegrees(rollRad.toDouble()).toFloat()
                        val isTilted = abs(pitchDeg) > 45f || abs(rollDeg) > 45f

                        trySend(
                            CompassSensorData(
                                azimuthDegrees = azimuthDeg,
                                accuracyText = currentAccuracyText,
                                isTilted = isTilted,
                                hasSensors = true,
                                sensorType = "Magnetic + Accelerometer"
                            )
                        )
                    }
                }
            }

            override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
                currentAccuracyText = when (accuracy) {
                    SensorManager.SENSOR_STATUS_ACCURACY_HIGH -> "Akurasi Tinggi (Terkalibrasi)"
                    SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM -> "Akurasi Sedang"
                    SensorManager.SENSOR_STATUS_ACCURACY_LOW -> "Perlu Kalibrasi (Gerakkan Angka 8)"
                    SensorManager.SENSOR_STATUS_UNRELIABLE -> "Sensor Belum Dikalibrasi"
                    else -> "Sensor Aktif"
                }
            }
        }

        // Gunakan SENSOR_DELAY_GAME (50Hz) untuk gerakan jarum yang langsung responsif tanpa jeda
        if (hasRotationVector) {
            sensorManager.registerListener(listener, rotationVector, SensorManager.SENSOR_DELAY_GAME)
        } else {
            sensorManager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_GAME)
            sensorManager.registerListener(listener, magnetometer, SensorManager.SENSOR_DELAY_GAME)
        }

        awaitClose {
            sensorManager.unregisterListener(listener)
        }
    }
}

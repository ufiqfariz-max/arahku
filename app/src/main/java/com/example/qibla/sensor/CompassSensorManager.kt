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

class CompassSensorManager(context: Context) {

    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    private val magnetometer: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

    data class CompassSensorData(
        val azimuthDegrees: Float,
        val accuracyText: String,
        val isTilted: Boolean, // True jika hp miring > 40 derajat
        val hasSensors: Boolean
    )

    fun getCompassDataFlow(): Flow<CompassSensorData> = callbackFlow {
        if (accelerometer == null || magnetometer == null) {
            trySend(
                CompassSensorData(
                    azimuthDegrees = 0f,
                    accuracyText = "Sensor Magnetik Tidak Tersedia",
                    isTilted = false,
                    hasSensors = false
                )
            )
            close()
            return@callbackFlow
        }

        val gravity = FloatArray(3)
        val geomagnetic = FloatArray(3)
        val rotationMatrix = FloatArray(9)
        val orientationAngles = FloatArray(3)

        var hasGravity = false
        var hasGeomagnetic = false
        var currentAccuracyText = "Akurat"

        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                val alpha = 0.15f // Koefisien Low-Pass Filter untuk peredam getaran

                when (event.sensor.type) {
                    Sensor.TYPE_ACCELEROMETER -> {
                        gravity[0] = gravity[0] + alpha * (event.values[0] - gravity[0])
                        gravity[1] = gravity[1] + alpha * (event.values[1] - gravity[1])
                        gravity[2] = gravity[2] + alpha * (event.values[2] - gravity[2])
                        hasGravity = true
                    }
                    Sensor.TYPE_MAGNETIC_FIELD -> {
                        geomagnetic[0] = geomagnetic[0] + alpha * (event.values[0] - geomagnetic[0])
                        geomagnetic[1] = geomagnetic[1] + alpha * (event.values[1] - geomagnetic[1])
                        geomagnetic[2] = geomagnetic[2] + alpha * (event.values[2] - geomagnetic[2])
                        hasGeomagnetic = true
                    }
                }

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
                        val isTilted = abs(pitchDeg) > 40f || abs(rollDeg) > 40f

                        trySend(
                            CompassSensorData(
                                azimuthDegrees = azimuthDeg,
                                accuracyText = currentAccuracyText,
                                isTilted = isTilted,
                                hasSensors = true
                            )
                        )
                    }
                }
            }

            override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
                if (sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
                    currentAccuracyText = when (accuracy) {
                        SensorManager.SENSOR_STATUS_ACCURACY_HIGH -> "Akurasi Tinggi"
                        SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM -> "Akurasi Sedang"
                        SensorManager.SENSOR_STATUS_ACCURACY_LOW -> "Kalibrasi (Gerakkan Angka 8)"
                        SensorManager.SENSOR_STATUS_UNRELIABLE -> "Perlu Kalibrasi"
                        else -> "Siap"
                    }
                }
            }
        }

        sensorManager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_UI)
        sensorManager.registerListener(listener, magnetometer, SensorManager.SENSOR_DELAY_UI)

        awaitClose {
            sensorManager.unregisterListener(listener)
        }
    }
}

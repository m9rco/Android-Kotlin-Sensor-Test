package com.example.sandy.kotlin_sensor_test

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var sManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager

        var sensor=sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sManager.registerListener(object :SensorEventListener{
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

            override fun onSensorChanged(event: SensorEvent?) {

                var values:FloatArray = event!!.values
                textView.text = values[0].toString()
                textView2.text = values[1].toString()

            }


        },sensor,SensorManager.SENSOR_DELAY_NORMAL)

    }
}

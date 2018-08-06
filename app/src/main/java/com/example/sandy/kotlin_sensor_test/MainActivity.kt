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


       accelerometer()
        proximity()
        gyroscope()

    }

    fun accelerometer(){

        var sManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager

        var sensor=sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sManager.registerListener(object :SensorEventListener{
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }

            override fun onSensorChanged(event: SensorEvent?) {

                var values:FloatArray = event!!.values
                textView.text = "X: " +values[0].toString()
                textView2.text ="Y: "+ values[1].toString()

            }


        },sensor,SensorManager.SENSOR_DELAY_NORMAL)


    }

    fun proximity(){


        var sManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager

        var sensor=sManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        sManager.registerListener(object :SensorEventListener{
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }

            override fun onSensorChanged(event: SensorEvent?) {

                var values:FloatArray = event!!.values
                textView5.text = values[0].toString()


            }


        },sensor,SensorManager.SENSOR_DELAY_NORMAL)

    }

    fun gyroscope(){

        var sManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager

        var sensor=sManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)  //Sensor type

        sManager.registerListener(object :SensorEventListener{
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }

            override fun onSensorChanged(event: SensorEvent?) {

                var values:FloatArray = event!!.values
                textView7.text = "X: " +values[0].toString()
                textView8.text ="Y: "+ values[1].toString()


            }


        },sensor,SensorManager.SENSOR_DELAY_NORMAL)


    }


}

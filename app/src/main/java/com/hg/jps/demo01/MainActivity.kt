package com.hg.jps.demo01

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import com.hg.jps.R

class MainActivity : AppCompatActivity() {

    private lateinit var chronometer: Chronometer
    private var elapseTime: Long = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometer = findViewById(R.id.chronometer)
    }

    override fun onResume() {
        super.onResume()
        chronometer.base = SystemClock.elapsedRealtime() - elapseTime
        chronometer.start()
    }

    override fun onPause() {
        super.onPause()
        elapseTime = SystemClock.elapsedRealtime() - chronometer.base
        chronometer.stop()
    }
}
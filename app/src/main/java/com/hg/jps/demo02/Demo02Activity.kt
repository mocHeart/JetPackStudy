package com.hg.jps.demo02

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hg.jps.R
import com.hg.jps.model.TAG

@SuppressLint("MissingInflatedId")
class Demo02Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo02)

        // 启动Service
        findViewById<Button>(R.id.dm02_btn_start).setOnClickListener {
            Log.i(TAG, "dm02_btn_start")
            startService(Intent(this, MyLocationService::class.java))
        }

        // 停止Service
        findViewById<Button>(R.id.dm02_btn_stop).setOnClickListener {
            Log.i(TAG, "dm02_btn_stop")
            stopService(Intent(this, MyLocationService::class.java))
        }

    }
}
package com.hg.jps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hg.jps.demo01.Demo01Activity
import com.hg.jps.demo02.Demo02Activity

class MainActivity : AppCompatActivity() {
    private var intent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Demo01:LifeCycle解耦组件-定时器
        findViewById<Button>(R.id.btn_dem01).setOnClickListener{
            intent = Intent(this, Demo01Activity::class.java)
            startActivity(intent)
        }

        // Demo02:LifeCycle解耦Service-定位服务
        findViewById<Button>(R.id.btn_dem02).setOnClickListener{
            intent = Intent(this, Demo02Activity::class.java)
            startActivity(intent)
        }

        // Demo02:LifeCycle解耦Service-定位服务
        findViewById<Button>(R.id.btn_dem02).setOnClickListener{
            intent = Intent(this, Demo02Activity::class.java)
            startActivity(intent)
        }
    }
}

package com.hg.jps.demo08

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hg.jps.R
import com.hg.jps.databinding.ActivityDemo08Binding
import com.hg.jps.demo07.Idol

class Demo08Activity : AppCompatActivity() {

    private lateinit var demo08Activity: ActivityDemo08Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        demo08Activity = DataBindingUtil.setContentView(this, R.layout.activity_demo08)

        // 文本内容绑定
        val idol = Idol("MyBatisPlus", 5)
        demo08Activity.idol = idol
    }
}
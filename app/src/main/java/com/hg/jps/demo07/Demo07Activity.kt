package com.hg.jps.demo07

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hg.jps.R
import com.hg.jps.databinding.ActivityDemo07Binding

class Demo07Activity : AppCompatActivity() {

    private lateinit var demo07Binding: ActivityDemo07Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        demo07Binding = DataBindingUtil.setContentView(this, R.layout.activity_demo07)

        // 文本内容绑定
        val idol = Idol("MyBatisPlus", 5)
        demo07Binding.idol = idol

        // 按钮绑定点击事件
        demo07Binding.eventHandle = EventHandleListener(this)
    }
}

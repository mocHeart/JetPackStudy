package com.hg.jps.demo10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hg.jps.R
import com.hg.jps.databinding.ActivityDemo10Binding

class Demo10Activity : AppCompatActivity() {

    private lateinit var demo10Binding: ActivityDemo10Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        demo10Binding = DataBindingUtil.setContentView(this, R.layout.activity_demo10)

        demo10Binding.userViewModel = UserViewModel(User("小明"))

    }
}
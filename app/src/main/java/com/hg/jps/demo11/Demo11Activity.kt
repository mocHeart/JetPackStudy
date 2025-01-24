package com.hg.jps.demo11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hg.jps.R
import com.hg.jps.databinding.ActivityDemo11Binding
import com.hg.jps.demo10.User

class Demo11Activity : AppCompatActivity() {

    private lateinit var demo11Binding: ActivityDemo11Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        demo11Binding = DataBindingUtil.setContentView(this, R.layout.activity_demo11)

        demo11Binding.userViewModel = UserViewModel(User("小明"))
    }
}
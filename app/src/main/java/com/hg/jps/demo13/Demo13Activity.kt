package com.hg.jps.demo13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hg.jps.R
import com.hg.jps.databinding.ActivityDemo13Binding

class Demo13Activity : AppCompatActivity() {

    private lateinit var demo13Binding: ActivityDemo13Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        demo13Binding = DataBindingUtil.setContentView(this, R.layout.activity_demo13)

        var viewModel: MyViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        )[MyViewModel::class.java]
        demo13Binding.viewModel = viewModel
        demo13Binding.lifecycleOwner = this
    }
}
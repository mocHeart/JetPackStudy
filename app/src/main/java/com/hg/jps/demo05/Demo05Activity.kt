package com.hg.jps.demo05

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hg.jps.R
import java.util.Timer
import java.util.TimerTask

@SuppressLint("MissingInflatedId", "SetTextI18n")
class Demo05Activity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo05)

        textView = findViewById(R.id.dm05_num_tv)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        )[MyViewModel::class.java]
        textView.text = viewModel.getCurrentSecond().value.toString()

        // ViewModel添加观察者自动更新 (Kotlin lambda表达式)
        // viewModel.getCurrentSecond().observe(this, { value -> textView.text = value.toString() }
        viewModel.getCurrentSecond().observe(this, object : Observer<Int> {
            override fun onChanged(value: Int) {
                textView.text = value.toString()
            }
        })
        startTimer()
    }

    private fun startTimer() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                // UI线程 setValue 非UI线程 postValue
                viewModel.getCurrentSecond()
                    .postValue(viewModel.getCurrentSecond().value?.plus(1) ?: 0)
            }
        }, 1000, 1000)
    }


}
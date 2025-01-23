package com.hg.jps.demo04

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hg.jps.R

@SuppressLint("MissingInflatedId", "SetTextI18n")
class Demo04Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var numTv: TextView
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo04)

        numTv = findViewById(R.id.dm04_num_tv)
        findViewById<Button>(R.id.dm04_plus_btn).setOnClickListener(this)

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory(application)).get(MyViewModel::class.java)
        numTv.text = viewModel.number.toString()
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.dm04_plus_btn) {
            numTv.text = (++viewModel.number).toString()
        }
    }

}
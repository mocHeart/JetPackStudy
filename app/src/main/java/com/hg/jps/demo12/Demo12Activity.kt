package com.hg.jps.demo12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.hg.jps.R
import com.hg.jps.databinding.ActivityDemo12Binding

class Demo12Activity : AppCompatActivity() {

    private lateinit var demo12Binding: ActivityDemo12Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        demo12Binding = DataBindingUtil.setContentView(this, R.layout.activity_demo12)


        val adapter = RecyclerViewAdapter(IdolUtil.getIdols())
        demo12Binding.demo12Recycleview.layoutManager = LinearLayoutManager(this)
        demo12Binding.demo12Recycleview.adapter = adapter
    }
}
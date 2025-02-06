package com.hg.jps.demo14

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hg.jps.R
import com.hg.jps.databinding.Demo14ItemBinding

class StudentRecyclerViewAdapter(var students: List<Student>) :
    RecyclerView.Adapter<StudentRecyclerViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding: Demo14ItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.demo14_item,
            parent,
            false
        )
        return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student: Student = students[position]
        Log.i("JY>>", "position: $position")
        Log.i("JY>>", "$>：" + student.id + " " + student.name + " " + student.age )
        holder.itemBinding.student = student
    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        lateinit var itemBinding: Demo14ItemBinding

        constructor(binding: Demo14ItemBinding) : this(binding.root) {
            itemBinding = binding
        }
    }

}
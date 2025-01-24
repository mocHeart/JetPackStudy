package com.hg.jps.demo12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hg.jps.R
import com.hg.jps.databinding.Demo12ItemBinding

class RecyclerViewAdapter(private var idols: List<Idol>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding: Demo12ItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.demo12_item,
            parent,
            false
        )
        return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return idols.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val idol: Idol = idols[position]
        holder.itemBinding.idol = idol
    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        lateinit var itemBinding: Demo12ItemBinding

        constructor(binding: Demo12ItemBinding) : this(binding.root) {
            itemBinding = binding
        }
    }

}


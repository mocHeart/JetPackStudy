package com.hg.jps.demo06

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var progress: MutableLiveData<Int>? = null

    fun getProgress(): MutableLiveData<Int> {
        if (progress == null) {
            progress = MutableLiveData<Int>()
            progress?.value = 0
        }
        return progress as MutableLiveData<Int>
    }

}
package com.hg.jps.demo05

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var currentSecond: MutableLiveData<Int>? = null

    fun getCurrentSecond(): MutableLiveData<Int> {
        if (currentSecond == null) {
            currentSecond = MutableLiveData<Int>()
            currentSecond?.value = 0
        }
        return currentSecond as MutableLiveData<Int>
    }

}
package com.hg.jps.demo02

import android.util.Log
import androidx.lifecycle.LifecycleService
import com.hg.jps.model.TAG

class MyLocationService : LifecycleService() {

    init {
        Log.i(TAG, "MyLocationService constructor().")
        lifecycle.addObserver(MyLocationObserver(this))
    }

}
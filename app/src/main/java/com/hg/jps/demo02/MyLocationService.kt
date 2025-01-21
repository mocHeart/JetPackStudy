package com.hg.jps.demo02

import android.util.Log
import androidx.lifecycle.LifecycleService

class MyLocationService : LifecycleService() {

    init {
        Log.i("LJY>>", "MyLocationService constructor().")
        lifecycle.addObserver(MyLocationObserver(this))
    }

}
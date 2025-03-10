package com.hg.jps.demo01

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyChronometer(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs), LifecycleObserver {

    private var elapseTime: Long = 0

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startMeter() {
        // SystemClock.elapsedRealtime(): 用于获取自设备启动以来经过的时间（以毫秒为单位）
        base = SystemClock.elapsedRealtime() - elapseTime
        start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopMeter() {
        elapseTime = SystemClock.elapsedRealtime() - base
        stop()
    }

}
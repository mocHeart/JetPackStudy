package com.hg.jps.demo02

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.media.AudioManager
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLocationObserver(var context: Context) : LifecycleObserver {

    lateinit var locationManager: LocationManager
    lateinit var myLocationListener: MyLocationListener

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startGetLocation() {
        Log.i("LJY>>", "startGetLocation()")

        //--------------------------测试
        var audioManager: AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        Log.i("LJY>>", "AudioMode: " + audioManager.mode)
        audioManager.mode = AudioManager.MODE_NORMAL
        Log.i("LJY>>", "AudioMode: " + audioManager.mode)
        //--------------------------

        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        myLocationListener = MyLocationListener()
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 1.0F, myLocationListener)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stopGetLocation() {
        Log.i("LJY>>", "stopGetLocation()")
        locationManager.removeUpdates(myLocationListener)
    }

    class MyLocationListener: LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.i("LJY>>", "Location changed: " + location.toString())
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            super.onStatusChanged(provider, status, extras)
        }

        override fun onProviderEnabled(provider: String) {
            super.onProviderEnabled(provider)
        }
    }
}
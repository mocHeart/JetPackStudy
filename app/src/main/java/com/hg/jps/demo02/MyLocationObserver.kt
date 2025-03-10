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
import com.hg.jps.model.TAG
import com.hjq.toast.Toaster

class MyLocationObserver(var context: Context) : LifecycleObserver {

    lateinit var locationManager: LocationManager
    lateinit var myLocationListener: MyLocationListener

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startGetLocation() {
        Log.i(TAG, "startGetLocation()")
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        myLocationListener = MyLocationListener()
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "定位权限未授予")
            return
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 1.0F, myLocationListener)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stopGetLocation() {
        Log.i(TAG, "stopGetLocation()")
        locationManager.removeUpdates(myLocationListener)
    }

    class MyLocationListener: LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.i(TAG, "Location changed: " + location.toString())
            Toaster.show("Location changed: " + location.toString())
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            super.onStatusChanged(provider, status, extras)
        }

        override fun onProviderEnabled(provider: String) {
            super.onProviderEnabled(provider)
        }
    }
}
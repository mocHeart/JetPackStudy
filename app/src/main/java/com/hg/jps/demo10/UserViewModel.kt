package com.hg.jps.demo10

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.hg.jps.BR

class UserViewModel(private var user: User): BaseObservable() {

    @Bindable
    fun getUsername(): String {
        return user.username
    }

    fun setUsername(username: String) {
        if (username != user.username) {
            user.username = username
            Log.i("JY>>", "set username: $username")
            notifyPropertyChanged(BR.username)
        }
    }


}
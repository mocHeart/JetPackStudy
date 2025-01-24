package com.hg.jps.demo11

import android.util.Log
import androidx.databinding.ObservableField
import com.hg.jps.demo10.User

class UserViewModel(user: User) {

    private var userObservableField: ObservableField<User> = ObservableField()

    init {
        userObservableField.set(user)
    }

    fun getUsername(): String {
        return userObservableField.get()?.username ?: ""
    }

    fun setUsername(username: String) {
        Log.i("JY>>", "set userObservableField: $username")
        userObservableField.get()?.username ?: ""
    }


}
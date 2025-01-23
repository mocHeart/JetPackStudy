package com.hg.jps.demo07

import android.content.Context
import android.view.View
import android.widget.Toast

class EventHandleListener(var context: Context) {

    fun buttonOnClick(view: View) {
        Toast.makeText(context, "喜欢", Toast.LENGTH_SHORT).show()
    }

}
package com.hg.jps.demo12

import android.graphics.Color
import android.text.TextUtils
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.hg.jps.R
import com.squareup.picasso.Picasso

class ImageViewBindingAdapter {

    companion object {
        // 加载网络图片
        @JvmStatic
        @BindingAdapter("demo12ItemImage")
        fun setImage(imageView: ImageView, url: String) {
            Log.i("JY>>", "网络图片地址：$url")
            if (!TextUtils.isEmpty(url)) {
                Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView)
            } else {
                imageView.setBackgroundColor(Color.CYAN)
            }
        }

    }

}
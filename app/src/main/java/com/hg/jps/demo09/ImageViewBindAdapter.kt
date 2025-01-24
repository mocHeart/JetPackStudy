package com.hg.jps.demo09

import android.graphics.Color
import android.text.TextUtils
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.hg.jps.R
import com.squareup.picasso.Picasso

class ImageViewBindAdapter {

    companion object {

        // 加载网络图片
        @JvmStatic
        @BindingAdapter("myImage")
        fun setImage(imageView: ImageView, url: String) {
            Log.i("JY>>", "网络图片地址：$url")
            if (!TextUtils.isEmpty(url)) {
                Picasso.get()
                    .load(url)
                    .resize(300, 300)
                    .placeholder(R.drawable.ic_launcher_background) // 加载图片时展示的临时图片
                    .into(imageView)
            } else {
                imageView.setBackgroundColor(Color.CYAN)
            }
        }

        // 加载本地图片
        @JvmStatic
        @BindingAdapter("myImage")
        fun setImage(imageView: ImageView, resId: Int) {
            Log.i("JY>>", "本地图片地址：$resId")
            imageView.setImageResource(resId)
        }

        // 参数可选，加载网络图片或本地图片
        @JvmStatic
        @BindingAdapter(value = ["myImage", "myDefaultImage"], requireAll = false)
        fun setImage(imageView: ImageView, url: String, resId: Int) {
            Log.i("JY>>", "本地或网络图片地址：$resId")
            if (!TextUtils.isEmpty(url)) {
                Picasso.get()
                    .load(url)
                    .resize(300, 300)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView)
            } else {
                imageView.setImageResource(resId)
            }
        }
    }

}
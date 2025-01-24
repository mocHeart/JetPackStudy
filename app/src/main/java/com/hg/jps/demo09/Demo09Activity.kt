package com.hg.jps.demo09

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hg.jps.R
import com.hg.jps.databinding.ActivityDemo09Binding

class Demo09Activity : AppCompatActivity() {

    private lateinit var demo09Binding: ActivityDemo09Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        demo09Binding = DataBindingUtil.setContentView(this, R.layout.activity_demo09)

        // 网络图片
        demo09Binding.networkImage = "https://i-blog.csdnimg.cn/blog_migrate/d315e1ce98792a191b061547778a217a.png"
        // 这个图显示不出来
        // "http://www.cxy521.com/static/img/index/devtool/dbeaver.png"

        // 本地图片
        demo09Binding.localImage = R.drawable.todotree
    }
}
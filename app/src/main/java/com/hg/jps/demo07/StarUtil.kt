package com.hg.jps.demo07

object StarUtil {
    @JvmStatic
    fun getStar(star: Int): String {
        return when (star) {
            1 -> "一星"
            2 -> "二星"
            3 -> "三星"
            4 -> "四星"
            5 -> "五星"
            else -> ""
        }
    }
}
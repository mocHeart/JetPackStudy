package com.hg.jps.demo12

object IdolUtil {

    @JvmStatic
    fun getIdols(): List<Idol> {
        val idols = mutableListOf<Idol>()
        idols.add(Idol("愤怒的兽人", "Angry-Orc", "https://pngate.com/wp-content/uploads/2023/09/Angry-Orc-Realistic-3D.png"))
        idols.add(Idol("美丽的未来派红龙", "Red-dragon", "https://pngate.com/wp-content/uploads/2023/09/Beautiful-futuristic-Red-dragon-3D-Model.png"))
        idols.add(Idol("蜘蛛侠", "Spiderman", "https://pngate.com/wp-content/uploads/2023/10/Spiderman-blows-a-spider-web-and-flies-away.png"))
        return idols
    }

}
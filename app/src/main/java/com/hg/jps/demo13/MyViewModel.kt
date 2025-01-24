package com.hg.jps.demo13

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var aTeamScore: MutableLiveData<Int>? = null
    private var bTeamScore: MutableLiveData<Int>? = null
    private var aLast: Int = 0
    private var bLast: Int = 0

    fun getATeamScore(): MutableLiveData<Int> {
        if (aTeamScore == null) {
            aTeamScore = MutableLiveData()
            aTeamScore!!.value = 0
        }
        return aTeamScore!!
    }

    fun getBTeamScore(): MutableLiveData<Int> {
        if (bTeamScore == null) {
            bTeamScore = MutableLiveData()
            bTeamScore!!.value = 0
        }
        return bTeamScore!!
    }

    fun aTeamAdd(i: Int) {
        savaLastScore()
        aTeamScore?.value = aTeamScore?.value?.plus(i)
    }

    fun bTeamAdd(i: Int) {
        savaLastScore()
        bTeamScore?.value = bTeamScore?.value?.plus(i)
    }

    fun undo() {
        aTeamScore?.value = aLast
        bTeamScore?.value = bLast
    }

    fun reset() {
        aTeamScore?.value = 0
        bTeamScore?.value = 0
    }

    fun savaLastScore() {
        aLast = aTeamScore?.value ?: 0
        bLast = bTeamScore?.value ?: 0
    }


}
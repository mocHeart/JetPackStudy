package com.hg.jps.demo04

import androidx.lifecycle.ViewModel

// 不要向ViewModel传入Context，会导致内容泄露
// 如需要使用Context，请使用AndroidViewModel中的Application
// class MyViewModel(var application: Application): AndroidViewModel(application) {
class MyViewModel: ViewModel() {

    var number: Int = 0

}
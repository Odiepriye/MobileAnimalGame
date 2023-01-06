package com.odiepriye.mymobilegame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyLevelModel : ViewModel() {
    val myLiveModel = MutableLiveData<LevelsList>()
    init{
        myLiveModel.value = LevelsList()
    }
}
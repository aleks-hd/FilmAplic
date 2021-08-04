package com.hfad.filmaplic.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel(val liveDataToObserver: MutableLiveData<Any> = MutableLiveData()) :
    ViewModel() {

    fun getData()=liveDataToObserver

    fun getWeather() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserver.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserver.postValue(AppState.Success(Any()))
        }.start()
    }
}
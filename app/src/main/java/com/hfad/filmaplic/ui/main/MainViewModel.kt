package com.hfad.filmaplic.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel(private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData(),
                    private val repositoryImpl: Repository = RepositoryImpl()
): ViewModel() {

fun getData(): LiveData<AppState> {
        return liveDataToObserver
    }

    fun getFilms() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserver.value = AppState.Loading
        Thread{
            Thread.sleep(1000)
            liveDataToObserver.postValue(AppState.Success(repositoryImpl.getFilmsFromLocal()))
        }.start()
    }
}
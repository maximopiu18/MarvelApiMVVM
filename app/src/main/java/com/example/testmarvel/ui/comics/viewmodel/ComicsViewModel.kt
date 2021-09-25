package com.core.mvvm.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testmarvel.ui.comics.model.Comics
import com.example.testmarvel.ui.comics.model.ResponseComics
import com.example.testmarvel.ui.comics.repository.ComicsRepository


class ComicsViewModel : ViewModel() {
    private var comicRepository: ComicsRepository? = null
    companion object {
        var mutableLiveData: MutableLiveData<ResponseComics>? = null
    }

    fun initRequest() {
        if (mutableLiveData != null) {
            return
        }
        comicRepository = ComicsRepository.getInstance()
        mutableLiveData = comicRepository!!.callServiceComics()
    }
    fun getModelResponse() : ResponseComics? {
        return mutableLiveData!!.value
    }

    fun newsRepository() :  MutableLiveData<ResponseComics>? {
        return mutableLiveData
    }




}




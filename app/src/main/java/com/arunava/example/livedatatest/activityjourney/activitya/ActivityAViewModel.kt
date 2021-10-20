package com.arunava.example.livedatatest.activityjourney.activitya

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ActivityAViewModel : ViewModel() {

    private val success: MutableLiveData<Boolean> = MutableLiveData()

    fun makeApiCall() {
        viewModelScope.launch {
            delay(3000)
            success.value = true
        }
    }

    fun getSuccessLiveData(): LiveData<Boolean> = success
}
package com.example.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel() : ViewModel() {
    private val _myData = MutableLiveData<Int>().apply { value = 0 }
    val myData: LiveData<Int>
        get() = _myData

    private val timer = Timer()

    init {
        // Scheduled a timer task to update the data every 10 seconds
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                updateData(2)
            }
        }, 0L, 1000)
    }
    override fun onCleared() {
        super.onCleared()
        // Cancel the timer task when the ViewModel is cleared
        timer.cancel()
    }

    fun updateData(newData: Int) {
        Handler(Looper.getMainLooper()).post {
            _myData.value = _myData.value?.plus(newData)
        }
    }

    
//    fun incrementNum() {
//        num.value = num.value?.plus(1)
//    }
}
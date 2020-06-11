package com.greatdayhr.training_mvvm.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greatdayhr.training_mvvm.data.MessageRepository

class MainViewModel : ViewModel() {
    var message = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()
    var isButtonShow = MutableLiveData<Int>().apply {
        View.VISIBLE
    }

    private var repository: MessageRepository = MessageRepository()

    fun getMessage() {
        isLoading.postValue(true)
        message.postValue("")

        repository.getMessage {
            isLoading.postValue(false)
            message.postValue(it)
        }
    }
}
package com.example.appactivitywithfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiverViewModel : ViewModel() {
    private val textMessageMutableData = MutableLiveData("")

    val textMessageLiveData: LiveData<String>
        get() = textMessageMutableData

    fun setMessageText(newMessageText: String?) {
        textMessageMutableData.value = newMessageText
    }
}
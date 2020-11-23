package com.yangPentingLulus.DCEMS.ui.utilities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UtilitiesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is utilities Fragment"
    }
    val text: LiveData<String> = _text
}
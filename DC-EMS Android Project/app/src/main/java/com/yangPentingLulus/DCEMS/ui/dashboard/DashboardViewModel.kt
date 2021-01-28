package com.yangPentingLulus.DCEMS.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yangPentingLulus.DCEMS.model.APIMain
import com.yangPentingLulus.DCEMS.model.Rack

class DashboardViewModel : ViewModel() {

    private var apiMain: APIMain? = null
    var rackListLiveData: LiveData<List<Rack>>? = null

    init {
        apiMain = APIMain()
        rackListLiveData = MutableLiveData()
    }

    fun fetchRackData(id: Int){
        rackListLiveData = apiMain?.fetchRackData(id)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}
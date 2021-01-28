package com.yangPentingLulus.DCEMS.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yangPentingLulus.DCEMS.model.APIClient
import com.yangPentingLulus.DCEMS.model.APIInterface
import com.yangPentingLulus.DCEMS.model.APIMain
import com.yangPentingLulus.DCEMS.model.Rack
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel : ViewModel() {


    private var apiInterface: APIInterface?=null
    private var apiMain: APIMain? = null
    var rackListLiveData: MutableLiveData<List<Rack>>? = null
    var rackList: ArrayList<Rack>? = null
    var mRack: Rack? = null

    init {
        apiInterface = APIClient.getAPIClient().create(APIInterface::class.java)
        apiMain = APIMain()
        rackListLiveData = MutableLiveData()
    }

    fun fetchRackDataTest(id: Int) {
        println("FETCHING")
        apiInterface?.fetchRackData(id)?.enqueue(object: Callback<List<Rack>> {

            override fun onFailure(call: Call<List<Rack>>, t: Throwable) {
                println("Failed to fetch data")
            }

            override fun onResponse(
                call: Call<List<Rack>>,
                response: Response<List<Rack>>
            ) {
                if (response.isSuccessful){
                    rackListLiveData?.value = response.body()
                }
            }
        })
    }

    fun fetchRackData(id: Int): ArrayList<Rack>? {
//        apiMain?.fetchRackData(id)
//        println("[DEBUG DASHBOARDVIEWMODEL] ${apiMain?.getRackData()}")
//        println("[Benerrr] ${apiMain?.publickRack?.value}")
        fetchRackDataTest(id)
        return apiMain?.getRackData()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}
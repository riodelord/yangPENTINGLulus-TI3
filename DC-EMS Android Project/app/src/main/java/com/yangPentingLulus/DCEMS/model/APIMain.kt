package com.yangPentingLulus.DCEMS.model


import com.yangPentingLulus.DCEMS.model.APIInterface
import com.yangPentingLulus.DCEMS.model.APIClient
import com.yangPentingLulus.DCEMS.model.Rack
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class APIMain {

    private var apiInterface:APIInterface?=null

    init {
        apiInterface = APIClient.getAPIClient().create(APIInterface::class.java)
    }

    fun fetchRackData(id: Int): LiveData<List<Rack>> {
        val rack = MutableLiveData<List<Rack>>()

        apiInterface?.fetchRackData(id)?.enqueue(object: Callback<List<Rack>>{

            override fun onFailure(call: Call<List<Rack>>, t: Throwable) {
                rack.value = null
            }

            override fun onResponse(
                call: Call<List<Rack>>,
                response: Response<List<Rack>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    rack.value = res
                }else{
                    rack.value = null
                }

            }
        })

        return rack
    }
}
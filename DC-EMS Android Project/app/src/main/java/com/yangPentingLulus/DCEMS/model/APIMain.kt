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
    private var rack = ArrayList<Rack>()
    var publickRack = MutableLiveData<MutableList<Rack>>()

    fun updateRackData(response: Response<List<Rack>>) {
        this.rack.add(response.body()!!.get(0))
        publickRack.value = response.body()!!.toMutableList()
    }

    fun getRackData(): ArrayList<Rack> {
        return this.rack
    }

    init {
        apiInterface = APIClient.getAPIClient().create(APIInterface::class.java)
    }

    fun fetchRackData(id: Int){
        var rack = ArrayList<Rack>()

        apiInterface?.fetchRackData(id)?.enqueue(object: Callback<List<Rack>>{

            override fun onFailure(call: Call<List<Rack>>, t: Throwable) {
                println("Failed to fetch data")
            }

            override fun onResponse(
                call: Call<List<Rack>>,
                response: Response<List<Rack>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    println("Got Response!!")
                    println("Body $res")
                    println("Data ${res.get(0)}")
                    updateRackData(response)
                    // data masih ada disini
                }else{
                    print("Response Code: ${response.code()}")
                }

            }
        })
    }
}
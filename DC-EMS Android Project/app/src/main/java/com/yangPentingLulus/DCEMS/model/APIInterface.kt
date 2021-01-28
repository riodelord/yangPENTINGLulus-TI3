package com.yangPentingLulus.DCEMS.model

import retrofit2.Call
import retrofit2.http.*
import com.yangPentingLulus.DCEMS.model.Rack

interface APIInterface {

    @GET("sensor/{id}")
    fun fetchRackData(
        @Path("id") id: Int
    ): Call<List<Rack>>

}
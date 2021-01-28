package com.yangPentingLulus.DCEMS.model

import retrofit2.Call
import retrofit2.http.*
import com.yangPentingLulus.DCEMS.model.Rack

interface APIInterface {

    @FormUrlEncoded
    @GET("sensor/{id}")
    fun fetchRackData(
        @Field("id") id: Int
    ): Call<List<Rack>>

}
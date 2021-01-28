package com.yangPentingLulus.DCEMS.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Rack(
    @SerializedName("th_id")
    var th_id: Integer? = null,
    @SerializedName("oid_hum")
    var oid_hum: String? = null,
    @SerializedName("value_hum")
    var value_hum: Double? = null,
    @SerializedName("oid_temp")
    var oid_temp: String? = null,
    @SerializedName("value_temp")
    var value_temp: Double? = null
)


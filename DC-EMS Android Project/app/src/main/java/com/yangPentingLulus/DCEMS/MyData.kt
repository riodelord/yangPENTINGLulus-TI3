package com.yangPentingLulus.DCEMS

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyData(
    var name: String,
    var temperature: Double,
    var humidity: Double,
    var status: String
) : Parcelable
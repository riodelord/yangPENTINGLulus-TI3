package com.yangPentingLulus.DCEMS

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyData(
    var name: String,
    var temperature: String,
    var humidity: String,
    var status: String
) : Parcelable
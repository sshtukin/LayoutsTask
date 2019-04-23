package com.sshtukin.layoutstask

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlightInfo (
    val  date : String,
    val  freeSeats: String,
    val cost : String,
    val placeFrom : String,
    val placeTo : String,
    val departTime : String,
    val arriveTime : String,
    val totalTime : String
): Parcelable
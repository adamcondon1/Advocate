package com.x18392911.final.advocate.recommendations.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse3(
    @SerializedName("results")
    val movie3s : List<Movie3>

) : Parcelable {
    constructor() : this(mutableListOf())
}
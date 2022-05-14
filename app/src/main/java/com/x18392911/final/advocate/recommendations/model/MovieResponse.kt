package com.x18392911.final.advocate.recommendations.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movie1s : List<Movie1>

) : Parcelable {
    constructor() : this(mutableListOf())
}
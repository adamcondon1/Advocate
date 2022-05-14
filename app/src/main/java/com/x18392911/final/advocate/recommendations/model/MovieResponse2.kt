package com.x18392911.final.advocate.recommendations.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse2(
    @SerializedName("results")
    val movie2s : List<Movie2>

) : Parcelable {
    constructor() : this(mutableListOf())
}
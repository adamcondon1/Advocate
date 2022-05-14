package com.x18392911.final.advocate.recommendations.data

//movie vars
data class Movie(
    val id: Int,
    val title: String,
    val genres: List<String>,
    val count: Int,
    var liked: Boolean
)
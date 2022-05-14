package com.x18392911.final.advocate.recommendations.data

//product vars
data class Product (
    val id: Int,
    val productName: String,
    val productDescription: String,
    val price: Int,
    var rating: Int=0
)
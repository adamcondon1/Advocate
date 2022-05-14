package com.x18392911.final.advocate.recommendations.data.source

import com.x18392911.final.advocate.recommendations.data.Product

interface ProductDataSource {

    fun getProduct(productId: Int): Product?

    fun getProducts(): List<Product>
}
package com.x18392911.final.advocate.recommendations.data.source

import com.x18392911.final.advocate.recommendations.data.DummyProductData
import com.x18392911.final.advocate.recommendations.data.Product

object ProductRemoteDataSource : ProductDataSource {

    private var PRODUCT_REMOTE_DATA = LinkedHashMap<Int, Product>(DummyProductData.products.size)

    init {
        for (product in DummyProductData.products) {
            addProduct(product)
        }
    }

    //getting all product movies by from array list
    override fun getProducts(): List<Product> {
        return ArrayList(PRODUCT_REMOTE_DATA.values)
    }

    override fun getProduct(productId: Int): Product? {
        return PRODUCT_REMOTE_DATA[productId]
    }

    private fun addProduct(product: Product) {
        PRODUCT_REMOTE_DATA.put(product.id, product)
    }

}
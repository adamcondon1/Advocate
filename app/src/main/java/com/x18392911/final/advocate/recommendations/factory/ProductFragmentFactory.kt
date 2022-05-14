package com.x18392911.final.advocate.recommendations.factory

import androidx.fragment.app.FragmentFactory
import com.x18392911.final.advocate.recommendations.Cart.ProductDetailFragment
import com.x18392911.final.advocate.recommendations.Cart.ProductListFragment
import com.x18392911.final.advocate.recommendations.data.source.ProductDataSource
import com.bumptech.glide.request.RequestOptions

//product list and data source storage
class ProductFragmentFactory(
    private val requestOptions: RequestOptions? = null,
    private val productDataSource: ProductDataSource? = null
) : FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            ProductListFragment::class.java.name -> {
                if (productDataSource != null) {
                    ProductListFragment(productDataSource)
                } else {
                    super.instantiate(classLoader, className)
                }
            }

            ProductDetailFragment::class.java.name -> {
                if(requestOptions != null
                    && productDataSource != null){
                    ProductDetailFragment(
                        requestOptions,
                        productDataSource
                    )
                }
                else{
                    super.instantiate(classLoader, className)
                }
            }
            else -> {
                super.instantiate(classLoader, className)
            }
        }

}














package com.x18392911.final.advocate.recommendations.Cart

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.RequestOptions
import com.x18392911.final.advocate.recommendations.R
import com.x18392911.final.advocate.recommendations.data.source.ProductDataSource
import com.x18392911.final.advocate.recommendations.data.source.ProductRemoteDataSource
import com.x18392911.final.advocate.recommendations.factory.ProductFragmentFactory
import com.x18392911.final.advocate.recommendations.utils.SharedPreferenceUtil
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity4 : AppCompatActivity(), UICommunicationListener {

    private lateinit var requestOptions: RequestOptions
    private lateinit var productDataSource: ProductDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = ProductFragmentFactory(
            requestOptions,
            productDataSource
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        cartCount();
        init()
    }

    //Count when movie added to the cart
    fun cartCount() {
        var arrayList = SharedPreferenceUtil.getArrayList(this.applicationContext)
        if (arrayList.size > 0) {
            textViewCount.visibility = View.VISIBLE
            textViewCount.text = arrayList.size.toString()
        } else {
            textViewCount.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        cartCount()
    }
    
    private fun init() {
        if (supportFragmentManager.fragments.size == 0) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProductListFragment::class.java, null)
                .commit()
        }

        //relative layout for cart items (wishlist)
        relativeLayoutCart.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this@MainActivity4, CartActivity::class.java)
            startActivity(intent)
        })
    }

    private fun initDependencies() {
        if (!::requestOptions.isInitialized) {
            // glide
            requestOptions = RequestOptions
                .placeholderOf(R.drawable.advocatelogo)
                .error(R.drawable.advocatelogo)
        }
        if (!::productDataSource.isInitialized) {
            // Data Source
            productDataSource = ProductRemoteDataSource
        }
    }

    override fun loading(isLoading: Boolean) {
        if (isLoading)
            progress_bar.visibility = View.VISIBLE
        else
            progress_bar.visibility = View.INVISIBLE
    }


}

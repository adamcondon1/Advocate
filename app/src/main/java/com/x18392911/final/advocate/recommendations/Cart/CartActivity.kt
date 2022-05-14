package com.x18392911.final.advocate.recommendations.Cart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.x18392911.final.advocate.freerecommendations.HomeRecommendations
import com.x18392911.final.advocate.recommendations.R
import com.x18392911.final.advocate.recommendations.data.Product
import com.x18392911.final.advocate.recommendations.ui.adapter.CartProductListAdapter
import com.x18392911.final.advocate.recommendations.utils.SharedPreferenceUtil
import com.x18392911.final.advocate.recommendations.utils.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.fragment_product_list.*

class CartActivity : AppCompatActivity() {

    lateinit var listAdapter: CartProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        init()
        initRecyclerView()

        //button and intent
        var Recommendations = findViewById(R.id.btnRecommendations) as Button
        Recommendations.setOnClickListener {
            val intent = Intent  (this, HomeRecommendations::class.java)
            startActivity(intent)
        }
    }

    //cart recylcer view
    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CartActivity)
            removeItemDecoration(TopSpacingItemDecoration(30))
            addItemDecoration(TopSpacingItemDecoration(30))
            listAdapter = CartProductListAdapter()
            adapter = listAdapter
        }
        var arrayList: ArrayList<Product> = SharedPreferenceUtil.getArrayList(this)
        var map = arrayList.groupBy { it -> it.rating }
        listAdapter.submitList(arrayList)
    }

    private fun init() {
        buttonBuy.setOnClickListener(View.OnClickListener {
            SharedPreferenceUtil.clear(this@CartActivity)
            recyclerView.visibility = View.GONE
            buttonBuy.visibility = View.GONE
            btnRecommendations.visibility = View.GONE
            textViewSuccess.visibility = View.VISIBLE
        })
    }
}

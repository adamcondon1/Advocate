package com.x18392911.final.advocate.freerecommendations

import FamilyAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adamc.advocate.R

class FamilyRecommendations : AppCompatActivity() {

    var familymovies = arrayOf(
        "Home",
        "Matilda",
        "Dory",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_recommendations)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = FamilyAdapter(familymovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
package com.x18392911.final.advocate.freerecommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adamc.advocate.R
import com.example.arraylistinstringandrecyclerview.ThrillerAdapter

class ThrillerRecommendations : AppCompatActivity() {

    var thrillermovies = arrayOf(
        "The General",
        "Snatch",
        "Hannibal",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thriller_recommendations)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ThrillerAdapter(thrillermovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
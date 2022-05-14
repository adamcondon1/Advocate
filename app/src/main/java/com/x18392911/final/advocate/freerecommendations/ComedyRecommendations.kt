package com.x18392911.final.advocate.freerecommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.x18392911.final.advocate.recommendations.R


class ComedyRecommendations : AppCompatActivity() {

    var comedymovies = arrayOf(
        "Project X",
        "Hangover",
        "Just go with It",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comedy_recommendations)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ComedyAdapter(comedymovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
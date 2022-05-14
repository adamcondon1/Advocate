package com.x18392911.final.advocate.freerecommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adamc.advocate.R
import com.example.arraylistinstringandrecyclerview.RomanceAdapter

class RomanceRecommendations : AppCompatActivity() {

    var romancemovies = arrayOf(
        "Never Been Kissed",
        "Suprise Me",
        "Dear John",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_romance_recommendations)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = RomanceAdapter(romancemovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
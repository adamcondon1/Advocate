package com.x18392911.final.advocate.freerecommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adamc.advocate.R
import com.example.arraylistinstringandrecyclerview.HorrorAdapter

class HorrorRecommendations : AppCompatActivity() {

    var horrormovies = arrayOf(
        "The Evil Down Street",
        "the Girl Next Door",
        "The Curse Of Humpty Dumpty",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horror_recommendations)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = HorrorAdapter(horrormovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
package com.x18392911.final.advocate.freerecommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adamc.advocate.R
import com.example.arraylistinstringandrecyclerview.MusicAdapter

class MusicRecommendations : AppCompatActivity() {

    var musicmovies = arrayOf(
        "High School Music",
        "Teen Musical",
        "Step up",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_recommendations)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = MusicAdapter(musicmovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
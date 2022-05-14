package com.x18392911.final.advocate.freerecommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adamc.advocate.R
import com.example.arraylistinstringandrecyclerview.DramaAdapter

class DramaRecommendation : AppCompatActivity() {

    var dramamovies = arrayOf(
        "The Score",
        "Shakespeare",
        "Green Street",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drama_recommendation)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = DramaAdapter(dramamovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
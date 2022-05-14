package com.x18392911.final.advocate.freerecommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adamc.advocate.R
import com.example.arraylistinstringandrecyclerview.CrimeAdapter

class CrimeRecommendations : AppCompatActivity() {

    var crimemovies = arrayOf(
        "Snatch",
        "Straigh Outta Compton",
        "Green Street Hooligans",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crimerecommendations)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = CrimeAdapter(crimemovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
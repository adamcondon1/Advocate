package com.x18392911.final.advocate.freerecommendations

import HistoryAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adamc.advocate.R

class HistoryRecommendatons : AppCompatActivity() {

    var historymovies = arrayOf(
        "Anne Frank (Whole Story)",
        "Tucemsuth",
        "World War 2",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_recommendatons)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = HistoryAdapter(historymovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
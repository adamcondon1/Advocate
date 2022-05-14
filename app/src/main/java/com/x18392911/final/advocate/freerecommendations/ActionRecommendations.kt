package com.x18392911.final.advocate.freerecommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.x18392911.final.advocate.recommendations.R


class ActionRecommendations : AppCompatActivity() {

    var actionmovies = arrayOf(
        "Limitless",
        "Fast and Furious",
        "Snatch",
    )

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_recommendations)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ActionAdapter(actionmovies, this)
        recyclerView!!.setAdapter(itemAdapter)
    }
}
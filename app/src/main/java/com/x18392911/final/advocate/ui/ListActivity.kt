package com.x18392911.final.advocate.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.x18392911.final.advocate.recommendations.listener.AdapterOnClickItemListener
import com.x18392911.final.advocate.recommendations.listener.OnTaskCompleted
import com.x18392911.final.advocate.recommendations.model.MovieTheater
import com.x18392911.final.advocate.ui.adapter.MovieTheaterAdapter
import com.x18392911.final.advocate.recommendations.R


//list of details including name and photo of cinema
class ListActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener,
    AdapterOnClickItemListener<MovieTheater>, OnTaskCompleted {

    private var movieTheaters: ArrayList<MovieTheater> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieTheaterAdapter

    private var currentLat:Double = 0.0
    private var currentLong:Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.x18392911.final.advocate.recommendations.R
                .layout.activity_list)

        intent.extras?.let{
            currentLat = it.get("lat") as Double
            currentLong = it.get("lng") as Double
            movieTheaters = it.get("list") as ArrayList<MovieTheater>
        }

        setUpViews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.x18392911.final.advocate.recommendations.R
                menu.list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.list_menu -> {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpViews() {
        recyclerView = findViewById(com.x18392911.final.advocate.recommendations.R
                .R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(false)

        adapter = MovieTheaterAdapter(movieTheaters)
        adapter.setListener(this)
        recyclerView.adapter = adapter

        findViewById<SwipeRefreshLayout>(R.id.swipe_layout).setOnRefreshListener(this)

        if (movieTheaters.isEmpty()) {
            getMovieTheaters()
        }
    }

    private fun getMovieTheaters() {
        //Query string
        val url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + currentLat + "," + currentLong +
                "&rankby=distance" + "&type=movie_theater&key=" + getString(R.string.google_maps_key)

        //Places task method to download json
        PlacesTask(this).execute(url)
    }

    override fun onRefresh() {
        getMovieTheaters()
    }

    override fun onItemClicked(position: Int, item: MovieTheater) {
        MovieTheaterDialogFragment.newInstance(item).show(supportFragmentManager, null)
    }

    override fun onTaskCompleted(list: ArrayList<MovieTheater>) {
        movieTheaters = list
        adapter.setMovieTheaters(movieTheaters)
        findViewById<SwipeRefreshLayout>(R.id.swipe_layout).isRefreshing = false
    }
}
package com.x18392911.final.advocate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.x18392911.final.advocate.recommendations.model.Movie1
import com.x18392911.final.advocate.recommendations.model.MovieResponse
import com.x18392911.final.advocate.recommendations.service.MovieApiInterface
import com.x18392911.final.advocate.recommendations.service.MovieApiService
import com.x18392911.final.advocate.recommendations.R
import kotlinx.android.synthetic.main.activity_mainapi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//getting movie from tmdb api storing in local db and projecting to a recylcerview
class MainAPIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainapi)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movie1s : List<Movie1> ->
            rv_movies_list.adapter = MovieAdapter(movie1s)
        }
    }

    private fun getMovieData(callback: (List<Movie1>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movie1s)
            }

        })
    }
}
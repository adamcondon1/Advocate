package com.x18392911.final.advocate.recommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.x18392911.final.advocate.recommendations.model.Movie3
import com.x18392911.final.advocate.recommendations.model.MovieResponse3
import com.x18392911.final.advocate.recommendations.service.MovieApiInterface3
import com.x18392911.final.advocate.recommendations.service.MovieApiService3
import com.x18392911.final.advocate.recommendations.R
import kotlinx.android.synthetic.main.activity_mainapi3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//main activity adapting activities for live data
class MainAPIActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainapi3)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movie3s : List<Movie3> ->
            rv_movies_list.adapter = MovieAdapter3(movie3s)
        }
    }

    private fun getMovieData(callback: (List<Movie3>) -> Unit){
        val apiService = MovieApiService3.getInstance().create(MovieApiInterface3::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse3> {
            override fun onFailure(call: Call<MovieResponse3>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse3>, response3: Response<MovieResponse3>) {
                return callback(response3.body()!!.movie3s)
            }

        })
    }
}
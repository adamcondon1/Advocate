package com.x18392911.final.advocate.recommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.x18392911.final.advocate.recommendations.model.Movie2
import com.x18392911.final.advocate.recommendations.model.MovieResponse2
import com.x18392911.final.advocate.recommendations.service.MovieApiInterface2
import com.x18392911.final.advocate.recommendations.service.MovieApiService2
import com.x18392911.final.advocate.recommendations.R
import kotlinx.android.synthetic.main.activity_mainapi2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//main activity adapting activities for live data
class MainAPIActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainapi2)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movie2s : List<Movie2> ->
            rv_movies_list.adapter = MovieAdapter2(movie2s)
        }
    }

    private fun getMovieData(callback: (List<Movie2>) -> Unit){
        val apiService = MovieApiService2.getInstance().create(MovieApiInterface2::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse2> {
            override fun onFailure(call: Call<MovieResponse2>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse2>, response2: Response<MovieResponse2>) {
                return callback(response2.body()!!.movie2s)
            }

        })
    }
}
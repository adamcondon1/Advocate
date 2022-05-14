package com.x18392911.final.advocate.recommendations.service

import com.x18392911.final.advocate.recommendations.model.MovieResponse2
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface2 {

    //Query to get top rated movies
    @GET("/3/movie/top_rated?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getMovieList(): Call<MovieResponse2>

}
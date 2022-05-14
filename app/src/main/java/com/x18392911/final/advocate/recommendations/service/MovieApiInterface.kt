package com.x18392911.final.advocate.recommendations.service


import com.x18392911.final.advocate.recommendations.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    //Query to get popular movies
    @GET("/3/movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getMovieList(): Call<MovieResponse>
}
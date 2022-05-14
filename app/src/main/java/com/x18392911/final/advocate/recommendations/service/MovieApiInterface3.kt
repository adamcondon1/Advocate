package com.x18392911.final.advocate.recommendations.service

import com.x18392911.final.advocate.recommendations.model.MovieResponse3
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface3 {

    //Query to get upcoming movies
    @GET("/3/movie/upcoming?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getMovieList(): Call<MovieResponse3>

}
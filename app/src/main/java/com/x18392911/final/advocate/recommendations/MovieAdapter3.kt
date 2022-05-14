package com.x18392911.final.advocate.recommendations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x18392911.final.advocate.recommendations.model.Movie3
import com.bumptech.glide.Glide
import com.x18392911.final.advocate.recommendations.R
import kotlinx.android.synthetic.main.movie_item3.view.*

class MovieAdapter3(
    private val movie3s : List<Movie3>
) : RecyclerView.Adapter<MovieAdapter3.MovieViewHolder>(){

    //gets uri and api from tmdb db
    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie3 : Movie3){
            itemView.movie_title.text = movie3.title
            itemView.movie_release_date.text = movie3.release
            Glide.with(itemView).load(IMAGE_BASE + movie3.poster).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item3, parent, false)
        )
    }

    override fun getItemCount(): Int = movie3s.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movie3s.get(position))
    }
}
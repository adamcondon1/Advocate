package com.x18392911.final.advocate.recommendations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x18392911.final.advocate.recommendations.model.Movie2
import com.bumptech.glide.Glide
import com.x18392911.final.advocate.recommendations.R
import kotlinx.android.synthetic.main.movie_item2.view.*

class MovieAdapter2(
    private val movie2s : List<Movie2>
) : RecyclerView.Adapter<MovieAdapter2.MovieViewHolder>(){

    //adapter that uses api tmdb to retrieve data
    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie2 : Movie2){
            itemView.movie_title.text = movie2.title
            itemView.movie_release_date.text = movie2.release
            Glide.with(itemView).load(IMAGE_BASE + movie2.poster).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item2, parent, false)
        )
    }

    override fun getItemCount(): Int = movie2s.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movie2s.get(position))
    }
}
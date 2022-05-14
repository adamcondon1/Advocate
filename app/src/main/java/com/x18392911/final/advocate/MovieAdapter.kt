package com.x18392911.final.advocate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x18392911.final.advocate.recommendations.model.Movie1
import com.bumptech.glide.Glide
import com.x18392911.final.advocate.recommendations.R
import kotlinx.android.synthetic.main.movie_item.view.*

//adapater for live data an api extraction
class MovieAdapter(
    private val movie1s : List<Movie1>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie1 : Movie1){
            itemView.movie_title.text = movie1.title
            itemView.movie_release_date.text = movie1.release
            Glide.with(itemView).load(IMAGE_BASE + movie1.poster).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movie1s.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movie1s.get(position))
    }
}
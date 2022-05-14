package com.x18392911.final.advocate.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x18392911.final.advocate.recommendations.listener.AdapterOnClickItemListener
import com.x18392911.final.advocate.recommendations.model.MovieTheater
import com.x18392911.final.advocate.recommendations.R


class MovieTheaterAdapter(list: ArrayList<MovieTheater>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mItems:ArrayList<MovieTheater> = list
    private var mListener: AdapterOnClickItemListener<MovieTheater>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieTheaterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.bikeshop_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MovieTheaterViewHolder).bind(mItems[position], mListener)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setMovieTheaters(movieTheaters: ArrayList<MovieTheater>) {
        mItems = movieTheaters
        notifyDataSetChanged()
    }

    fun setListener(listener: AdapterOnClickItemListener<MovieTheater>) {
        this.mListener = listener
    }

}
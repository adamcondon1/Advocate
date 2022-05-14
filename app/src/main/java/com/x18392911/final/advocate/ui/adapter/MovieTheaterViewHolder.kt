package com.x18392911.final.advocate.ui.adapter

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.x18392911.final.advocate.recommendations.listener.AdapterOnClickItemListener
import com.x18392911.final.advocate.recommendations.listener.OnPhotoCompleted
import com.x18392911.final.advocate.recommendations.model.MovieTheater
import com.x18392911.final.advocate.ui.PhotoTask
import com.x18392911.final.advocate.recommendations.R


class MovieTheaterViewHolder(view:View) : RecyclerView.ViewHolder(view), OnPhotoCompleted {

    lateinit var item: MovieTheater
    private var mListener: AdapterOnClickItemListener<MovieTheater>? = null

    fun bind(item: MovieTheater, listener: AdapterOnClickItemListener<MovieTheater>?) {
        this.item = item
        mListener = listener

        itemView.findViewById<TextView>(R.id.tv_name).text = item.name
        itemView.findViewById<TextView>(R.id.tv_address).text = item.address

        item.thumbnail?.let {
            val url = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=300&photoreference=" + it + "&key=" + itemView.context.getString(R.string.google_maps_key)
            PhotoTask(this).execute(url)
        }

        itemView.setOnClickListener {
            mListener?.onItemClicked(adapterPosition, item)
        }
    }

    override fun onPhotoCompleted(photo: Bitmap?) {
        itemView.findViewById<ImageView>(R.id.iv_photo).setImageBitmap(photo)
    }
}
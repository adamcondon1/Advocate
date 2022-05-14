package com.x18392911.final.advocate.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.x18392911.final.advocate.recommendations.listener.OnPhotoCompleted
import com.x18392911.final.advocate.recommendations.model.MovieTheater
import com.x18392911.final.advocate.recommendations.R


class MovieTheaterDialogFragment : DialogFragment(), OnPhotoCompleted {
    companion object {
        fun newInstance(movieTheater: MovieTheater) : MovieTheaterDialogFragment {
            val bsdf = MovieTheaterDialogFragment()
            bsdf.movieTheater = movieTheater
            return bsdf
        }
    }

    private var movieTheater: MovieTheater? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movietheater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tv_dialog_name).text = movieTheater?.name
        view.findViewById<TextView>(R.id.tv_dialog_address).text = movieTheater?.address

        movieTheater?.thumbnail?.let {
            val url = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=1500&photoreference=" + it + "&key=" + view.context.getString(R.string.google_maps_key)
            PhotoTask(this).execute(url)
        }
    }

    override fun onPhotoCompleted(photo: Bitmap?) {
        view?.findViewById<ImageView>(R.id.iv_dialog_photo)?.setImageBitmap(photo)
    }
}
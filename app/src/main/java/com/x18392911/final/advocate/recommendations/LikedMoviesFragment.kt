package com.x18392911.final.advocate.recommendations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.x18392911.final.advocate.recommendations.adapters.FilterType
import com.x18392911.final.advocate.recommendations.adapters.ItemClickListener
import com.x18392911.final.advocate.recommendations.adapters.MoviesAdapter
import com.x18392911.final.advocate.recommendations.data.Movie
import com.x18392911.final.advocate.recommendations.viewmodels.LikedMoviesViewModel
import com.x18392911.final.advocate.recommendations.R


/**
 * Fragment showing the list of movies the user has liked.
 */
class LikedMoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLikedMoviesBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val viewModel: LikedMoviesViewModel = ViewModelProvider(requireActivity()).get(
            LikedMoviesViewModel::class.java)
        val movieClickListener = object : ItemClickListener() {
            override fun onLike(movie: Movie) {
                throw Exception("Movie was already liked")
            }

            override fun onRemoveLike(movie: Movie) {
                viewModel.onMovieLikeRemoved(movie)
            }
        }
        val adapter = MoviesAdapter(movieClickListener, FilterType.LIKED)
        binding.list.adapter = adapter

        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitList(it.toList())
            adapter.notifyDataSetChanged()
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}
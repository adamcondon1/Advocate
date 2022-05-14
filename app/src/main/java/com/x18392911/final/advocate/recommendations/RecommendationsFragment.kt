package com.x18392911.final.advocate.recommendations

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.x18392911.final.advocate.recommendations.adapters.RecommendationsAdapter
import com.x18392911.final.advocate.recommendations.data.Movie
import com.x18392911.final.advocate.recommendations.utils.Config
import com.x18392911.final.advocate.recommendations.viewmodels.LikedMoviesViewModel
import com.x18392911.final.advocate.recommendations.databinding.FragmentRecommendationsBinding
import kotlinx.coroutines.launch

/**
 * A fragment containing the list of generated movie recommendations for the items in the Liked
 * page.
 */
class RecommendationsFragment : Fragment() {

    private var config = Config()
    private var client: RecommendationClient? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        client = RecommendationClient(requireContext(), config)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRecommendationsBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = RecommendationsAdapter()
        binding.list.adapter = adapter
        val viewModel: LikedMoviesViewModel = ViewModelProvider(requireActivity()).get(
            LikedMoviesViewModel::class.java)
        viewModel.movies.observe(viewLifecycleOwner) {
            recommend(it.filter { movie -> movie.liked }.toList(), adapter)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            client?.load()
        }
    }

    override fun onStop() {
        lifecycleScope.launch {
            client?.unload()
        }
        super.onStop()
    }

    /** Sends selected movie list and get recommendations.  */
    private fun recommend(movies: List<Movie>, adapter: RecommendationsAdapter) {
        lifecycleScope.launch {

            // Run inference with TF Lite.
            Log.d(TAG, "Run inference with TFLite model.")
            client?.recommend(movies)?.run {
                Log.d(TAG, toString())
                adapter.submitList(this)
            }
        }
    }

    companion object {
        private val TAG = "RecommendationsFragment";
    }
}
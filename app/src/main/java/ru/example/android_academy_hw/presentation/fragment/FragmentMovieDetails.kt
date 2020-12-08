package ru.example.android_academy_hw.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.example.android_academy_hw.databinding.FragmentMovieDetailsBinding
import ru.example.android_academy_hw.model.Movie
import ru.example.android_academy_hw.presentation.activity.Router
import ru.example.android_academy_hw.presentation.adapter.ActorListAdapter

class FragmentMovieDetails : Fragment() {

    private val router: Router by lazy { activity as Router }

    private var _binding: FragmentMovieDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater)

        val movie = arguments?.movie
        movie?.let {
            val adapter = ActorListAdapter()
            binding.apply {
                Glide.with(requireContext())
                    .load(movie.backdrop)
                    .centerCrop()
                    .into(backdrop)
                cast.visibility = if (movie.actors.isNullOrEmpty()) View.GONE else View.VISIBLE
                age.visibility = if (movie.adult) View.VISIBLE else View.INVISIBLE
                movieTitle.text = movie.title
                movieGenre.text = movie.genres.joinToString(", ") { it.name }
                storyLine2.text = movie.overview
                ratingBar.rating = movie.ratings / 2
                recyclerActors.adapter = adapter
                recyclerActors.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                backButton.setOnClickListener {
                    router.navigateUp()
                }

            }
            lifecycleScope.launchWhenCreated {
                adapter.setItems(it.actors)
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance(item: Movie) = FragmentMovieDetails().apply {
            arguments = Bundle().apply {
                movie = item
            }
        }

        var Bundle.movie: Movie?
            get() = getParcelable("movie")
            set(value) = putParcelable("movie", value)
    }
}
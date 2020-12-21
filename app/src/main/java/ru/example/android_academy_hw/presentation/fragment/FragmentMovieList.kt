package ru.example.android_academy_hw.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import ru.example.android_academy_hw.databinding.FragmentMovieListBinding
import ru.example.android_academy_hw.model.Movie
import ru.example.android_academy_hw.presentation.activity.Router
import ru.example.android_academy_hw.presentation.adapter.MovieListAdapter
import ru.example.android_academy_hw.presentation.adapter.base.ClickElementListener


class FragmentMovieList : Fragment() {

    private val router: Router by lazy { activity as Router }

    private val vm = ViewModelProviders.of(this).get(MovieDetailsViewModel::class.java)

    private var _binding: FragmentMovieListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater)

        val movieAdapter = MovieListAdapter(listener = object : ClickElementListener<Movie> {
            override fun onClick(item: Movie) {
                router.navigateTo(FragmentMovieDetails.newInstance(item))
            }
        })
        binding.movieListRv.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(context, 2)
        }

        vm.movies.asLiveData().observe(viewLifecycleOwner) {
            movieAdapter.setItems(it)
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMovieList()
    }
}
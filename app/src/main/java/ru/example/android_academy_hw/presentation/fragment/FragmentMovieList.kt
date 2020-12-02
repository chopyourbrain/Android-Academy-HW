package ru.example.android_academy_hw.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import ru.example.android_academy_hw.data.DataGenerator
import ru.example.android_academy_hw.presentation.adapter.MovieListAdapter
import ru.example.android_academy_hw.Router
import ru.example.android_academy_hw.databinding.FragmentMovieListBinding

class FragmentMovieList : Fragment() {

    private val router: Router by lazy { activity as Router }

    private var _binding: FragmentMovieListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater)

        val movieAdapter = MovieListAdapter()
        binding.movieListRv.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
        movieAdapter.apply {
            listener =
                View.OnClickListener { router.navigateTo(FragmentMovieDetails.newInstance()) }
            setItems(DataGenerator.generateMovieList())
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
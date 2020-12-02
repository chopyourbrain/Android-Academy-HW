package ru.example.android_academy_hw.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.example.android_academy_hw.data.DataGenerator
import ru.example.android_academy_hw.model.MovieData
import ru.example.android_academy_hw.Router
import ru.example.android_academy_hw.presentation.adapter.ActorListAdapter
import ru.example.android_academy_hw.databinding.FragmentMovieDetailsBinding

class FragmentMovieDetails : Fragment() {

    private val router: Router by lazy { activity as Router }

    private var _binding: FragmentMovieDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater)

        val adapter = ActorListAdapter()
        binding.apply {
            recyclerActors.adapter = adapter
            recyclerActors.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            backButton.setOnClickListener {
                router.navigateUp()
            }

        }
        adapter.setItems(DataGenerator.generateActorList())

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentMovieDetails().apply {
            arguments = Bundle().apply {
            }
        }

        var Bundle.movie: MovieData?
            get() = getParcelable("movie")
            set(value) = putParcelable("movie", value)
    }
}
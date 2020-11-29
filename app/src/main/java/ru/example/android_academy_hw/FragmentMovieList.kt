package ru.example.android_academy_hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import ru.example.android_academy_hw.databinding.FragmentMovieDetailsBinding
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

        binding.avengersCard.setOnClickListener {
            router.navigateTo(FragmentMovieDetails.newInstance())

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
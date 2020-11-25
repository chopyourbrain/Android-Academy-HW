package ru.example.android_academy_hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.example.android_academy_hw.databinding.FragmentMovieDetailsBinding

class FragmentMovieDetails : Fragment() {

    private val router: Router by lazy { activity as Router }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMovieDetailsBinding.inflate(inflater)
        binding.backButton.setOnClickListener { router.navigateUp() }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMovieDetails()
    }
}
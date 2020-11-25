package ru.example.android_academy_hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import ru.example.android_academy_hw.databinding.FragmentMovieListBinding

class FragmentMovieList : Fragment() {

    private val router: Router by lazy { activity as Router }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMovieListBinding.inflate(inflater)
        binding.avengersCard.setOnClickListener { router.navigateTo(FragmentMovieDetails.newInstance()) }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMovieList()
    }
}
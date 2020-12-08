package ru.example.android_academy_hw.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.example.android_academy_hw.data.MovieRepository
import ru.example.android_academy_hw.model.Movie

class MovieDetailsViewModel(private val repo: MovieRepository) : ViewModel() {

    val movies = MutableStateFlow<List<Movie>>(listOf())

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            movies.value = repo.loadMovies()
        }
    }

}
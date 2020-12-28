package ru.example.android_academy_hw.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.example.android_academy_hw.UiState
import ru.example.android_academy_hw.data.MovieRepository
import ru.example.android_academy_hw.model.Movie

class MovieDetailsViewModel(private val repo: MovieRepository) : ViewModel() {

    val movies = MutableStateFlow<UiState<List<Movie>>>(UiState.Empty())

    init {
        getMovies()
    }

    fun getMovies() {
        movies.value = UiState.Loading()
        viewModelScope.launch {
            delay(3000)
            movies.value = UiState.Success(repo.loadMovies())
        }
    }

}

class MovieViewModelFactory(private val repo: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }

}
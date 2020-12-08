package ru.example.android_academy_hw.data

import android.content.Context

class MovieRepository(private val context: Context) {
    suspend fun loadMovies() = loadMovies(context)
}
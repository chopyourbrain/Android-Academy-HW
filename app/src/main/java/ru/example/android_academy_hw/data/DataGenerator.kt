package ru.example.android_academy_hw.data

import ru.example.android_academy_hw.R
import ru.example.android_academy_hw.model.ActorData
import ru.example.android_academy_hw.model.MovieData

object DataGenerator {
    fun generateMovieList() = arrayListOf(
        MovieData(
            13,
            "Avengers: End Game",
            "Action, Adventure, Drama",
            "137 min",
            125,
            R.drawable.avengers_background
        ),
        MovieData(
            16,
            "Tenet",
            "Action, Sci-Fi, Thriller",
            "97 min",
            98,
            R.drawable.tenet_background
        ),
        MovieData(
            13,
            "Black Widow",
            "Action, Adventure, Sci-Fi",
            "102 min",
            38,
            R.drawable.black_widow_background
        ),
        MovieData(
            13,
            "Wonder Woman 1984",
            "Action, Adventure, Fantasy",
            "120 min",
            74,
            R.drawable.ww84_background
        )
    )

    fun generateActorList() = arrayListOf(
        ActorData(R.string.robert_downey_jr, R.drawable.rob_downey),
        ActorData(R.string.chris_evans, R.drawable.chris_evans),
        ActorData(R.string.mark_ruffalo, R.drawable.mark_ruffalo),
        ActorData(R.string.chris_hemsworth, R.drawable.chris_hemsworth),
    )
}
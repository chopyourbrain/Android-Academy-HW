package ru.example.android_academy_hw.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieData(
    val age: Int,
    val title: String,
    val genre: String,
    val runningTime: String,
    val reviewCount: Int,
    @DrawableRes
    val imageRes: Int
) : Parcelable

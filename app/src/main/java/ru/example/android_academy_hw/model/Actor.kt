package ru.example.android_academy_hw.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actor(
    val id: Int,
    val name: String,
    val picture: String
) : Parcelable
package ru.example.android_academy_hw.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActorData(
    @StringRes
    val name: Int,
    @DrawableRes
    val imageRes: Int
) : Parcelable

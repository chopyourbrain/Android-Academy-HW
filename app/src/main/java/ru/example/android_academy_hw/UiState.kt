package ru.example.android_academy_hw

sealed class UiState<T> {
    open class Success<T>(val data: T) : UiState<T>()
    open class Error<T>(val cause: String) : UiState<T>()
    open class Empty<T> : UiState<T>()
    open class Loading<T> : UiState<T>()
}
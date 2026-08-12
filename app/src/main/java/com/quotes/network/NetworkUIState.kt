package com.quotes.network

sealed class NetworkUIState<out T> {
    data object Loading : NetworkUIState<Nothing>()
    data class Success<T>(val data: T) : NetworkUIState<T>()
    data class Error(
        val message: String? = null,
        val throwable: Throwable? = null
    ) : NetworkUIState<Nothing>()
}
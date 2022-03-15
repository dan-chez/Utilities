package com.danchez.utilities.model

sealed class Resource<T>(val data: T? = null, val message: String? = null, val error: Exception? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String? = null, data: T? = null, error: Exception? = null) : Resource<T>(data, message, error)
}

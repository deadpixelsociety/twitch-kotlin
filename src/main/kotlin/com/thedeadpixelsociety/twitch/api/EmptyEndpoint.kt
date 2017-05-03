package com.thedeadpixelsociety.twitch.api

import retrofit2.Response

abstract class EmptyEndpoint : Endpoint {
    private var lastError: ErrorResponse? = null

    override fun lastError() = lastError

    override fun hasError() = lastError() != null

    protected fun <T> attempt(response: Response<T>?): T? {
        try {
            return verify(response)
        } catch (ex: Exception) {
            // TODO: Logging
            return null
        }
    }

    protected fun <T> verify(response: Response<T>?): T? {
        if (response == null) return null
        lastError = createError(response)
        return if (lastError == null) response.body() else null
    }

    private fun <T> createError(response: Response<T>): ErrorResponse? {
        return if (response.isSuccessful) null else Json.decode(response.errorBody()?.string())
    }
}

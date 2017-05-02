package com.thedeadpixelsociety.twitch.api

import retrofit2.Response

abstract class EmptyTwitchEndpoint : TwitchEndpoint {
    private var lastError: TwitchError? = null

    override fun lastError() = lastError

    override fun hasError() = lastError() != null

    protected fun <T> verify(response: Response<T>?): T? {
        if (response == null) return null
        lastError = createError(response)
        return if (lastError == null) response.body() else null
    }

    private fun <T> createError(response: Response<T>): TwitchError? {
        return if (response.isSuccessful) null else Json.decode(response.errorBody()?.string())
    }
}

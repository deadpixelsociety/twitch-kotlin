package com.thedeadpixelsociety.twitch.api

import retrofit2.Retrofit

/**
 * Defines a Twitch endpoint resource.
 */
interface TwitchEndpoint {
    /**
     * Gets the error information for the last request, if any.
     * @return A [TwitchError] if an error occured during the last request; otherwise, null.
     */
    fun lastError(): TwitchError?

    /**
     * Determines if an error has occurred.
     * @return true if an error exists; otherwise, false.
     * @see [lastError]
     */
    fun hasError(): Boolean

    /**
     * Initializes the endpoint with the specified [Retrofit] instance.
     * @param retrofit The [Retrofit] instance to use.
     */
    fun init(retrofit: Retrofit)
}
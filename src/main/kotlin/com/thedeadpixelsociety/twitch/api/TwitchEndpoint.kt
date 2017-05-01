package com.thedeadpixelsociety.twitch.api

import retrofit2.Retrofit

/**
 * Defines a Twitch endpoint resource.
 */
interface TwitchEndpoint {
    /**
     * Assigns the [Retrofit] adapter to query the endpoint with.
     * @param retrofit The [Retrofit] adapter to use.
     */
    fun with(retrofit: Retrofit)
}
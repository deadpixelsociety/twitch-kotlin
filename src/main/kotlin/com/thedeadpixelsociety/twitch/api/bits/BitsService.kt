package com.thedeadpixelsociety.twitch.api.bits

import retrofit2.http.GET
import retrofit2.http.Query

interface BitsService {
    @GET("bits/actions")
    fun cheermotes(@Query("channel_id") channelId: String? = null): BitsResponse
}
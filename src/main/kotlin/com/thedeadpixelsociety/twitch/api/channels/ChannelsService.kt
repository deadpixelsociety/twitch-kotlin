package com.thedeadpixelsociety.twitch.api.channels

import retrofit2.Call
import retrofit2.http.GET

interface ChannelsService {
    @GET("channel")
    fun channel(): Call<Channel>
}
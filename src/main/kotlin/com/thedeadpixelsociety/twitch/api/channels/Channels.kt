package com.thedeadpixelsociety.twitch.api.channels

import com.thedeadpixelsociety.twitch.api.EmptyEndpoint
import retrofit2.Retrofit

class Channels : EmptyEndpoint() {
    private var service: ChannelsService? = null

    override fun init(retrofit: Retrofit) {
        service = retrofit.create(ChannelsService::class.java)
    }

    /**
     * Gets a channel object based on a specified OAuth token.
     * @return A [Channel] if successful; otherwise, false.
     */
    fun channel(): Channel? {
        return attempt(service?.channel()?.execute())
    }
}
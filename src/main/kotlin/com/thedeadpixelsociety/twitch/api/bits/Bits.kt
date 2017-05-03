package com.thedeadpixelsociety.twitch.api.bits

import com.thedeadpixelsociety.twitch.api.EmptyEndpoint
import retrofit2.Retrofit

/**
 * Implements the Bits endpoint service. See https://dev.twitch.tv/docs/v5/reference/bits/.
 */
class Bits : EmptyEndpoint() {
    private var service: BitsService? = null

    override fun init(retrofit: Retrofit) {
        service = retrofit.create(BitsService::class.java)
    }

    /**
     * Retrieves the list of available cheermotes, animated emotes to which viewers can assign bits, to cheer in chat.
     * The cheermotes returned are available throughout Twitch, in all bits-enabled channels.
     * @param channelId If this is specified, the cheermote for this channel is included in the response (if the
     * channel owner has uploaded a channel-specific cheermote).
     * @return A [CheermotesResponse] if successful; otherwise, null.
     */
    fun cheermotes(channelId: String? = null): CheermotesResponse? {
        return attempt(service?.cheermotes(channelId)?.execute())
    }
}
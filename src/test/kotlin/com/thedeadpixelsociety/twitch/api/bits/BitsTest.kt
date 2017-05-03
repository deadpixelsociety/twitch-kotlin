package com.thedeadpixelsociety.twitch.api.bits

import com.thedeadpixelsociety.twitch.api.ApiTest
import org.junit.Assert
import org.junit.Test

class BitsTest : ApiTest() {
    @Test
    fun cheermotesWithoutChannelId() {
        val bits = client.get<Bits>()
        val response = bits.cheermotes()
        Assert.assertNotNull(response)
    }

    @Test
    fun cheermotesWithChannelId() {
        val bits = client.get<Bits>()
        val response = bits.cheermotes("dallas")
        Assert.assertNotNull(response)
    }
}
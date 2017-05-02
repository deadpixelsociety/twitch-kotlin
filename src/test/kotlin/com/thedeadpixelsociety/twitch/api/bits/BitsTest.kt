package com.thedeadpixelsociety.twitch.api.bits

import com.thedeadpixelsociety.twitch.TwitchClient
import com.thedeadpixelsociety.twitch.TwitchCredentials
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Test

class BitsTest {
    private val credentials by lazy { TwitchCredentials("uo6dggojyb8d6soh92zknwmi5ej1q2", "pk2bh6y1vi8mrn7l67bp9i6dpg2wnk") }
    private val client by lazy { TwitchClient.createDefault(credentials) }

    @Test
    fun cheermotesWithoutChannelId() {
        val bits = client.get<Bits>()
        val response = bits.cheermotes()
        Assert.assertNotNull(response)
    }

    @Test
    fun cheermotesWithChannelId() {
        val bits = client.get<Bits>()
        val response = bits.cheermotes("deadpixelsociety")
        Assert.assertNotNull(response)
    }

    @Test
    fun cheermotesAsyncWithoutChannelId() {
        runBlocking {
            val bits = client.get<Bits>()
            val response = bits.cheermotesAsync()
            Assert.assertNotNull(response.await())
        }
    }

    @Test
    fun cheermotesAsyncWithChannelId() {
        runBlocking {
            val bits = client.get<Bits>()
            val response = bits.cheermotesAsync("deadpixelsociety")
            Assert.assertNotNull(response.await())
        }
    }
}
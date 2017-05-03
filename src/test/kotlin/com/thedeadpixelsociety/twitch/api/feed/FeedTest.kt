package com.thedeadpixelsociety.twitch.api.feed

import com.thedeadpixelsociety.twitch.api.ApiTest
import org.junit.Assert
import org.junit.Test

class FeedTest : ApiTest() {
    @Test
    fun posts() {
        val feed = client.get<Feed>()
        val response = feed.posts(44322889)
        Assert.assertNotNull(response)
    }

    @Test
    fun postsLimit() {
        val feed = client.get<Feed>()
        val response = feed.posts(44322889, limit = 1)
        Assert.assertNotNull(response)
        Assert.assertTrue(response!!.posts.size <= 1)
    }

    @Test
    fun post() {
        val feed = client.get<Feed>()
        val response = feed.post(44322889, "1341393b-e872-4554-9f6f-acd5f8b669fc")
        Assert.assertNotNull(response)
    }
}
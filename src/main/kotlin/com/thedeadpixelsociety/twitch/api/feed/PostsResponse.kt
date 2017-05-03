package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName

data class PostsResponse(
    @SerializedName("_cursor")
    val cursor: String,
    @SerializedName("_topic")
    val topic: String,
    @SerializedName("_disabled")
    val disabled: Boolean,
    @SerializedName("posts")
    val posts: Posts
)
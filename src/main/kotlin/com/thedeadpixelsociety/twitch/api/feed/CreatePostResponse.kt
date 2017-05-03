package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName

data class CreatePostResponse(
    @SerializedName("post")
    val post: Post,
    @SerializedName("tweet")
    val tweet: String
)
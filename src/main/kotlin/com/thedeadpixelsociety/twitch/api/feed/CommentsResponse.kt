package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName

data class CommentsResponse(
    @SerializedName("_total")
    val total: Int,
    @SerializedName("_cursor")
    val cursor: String,
    @SerializedName("comments")
    val comments: Comments
)
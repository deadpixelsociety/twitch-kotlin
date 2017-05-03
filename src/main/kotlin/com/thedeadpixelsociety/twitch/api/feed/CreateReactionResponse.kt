package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName
import com.thedeadpixelsociety.twitch.api.users.User

data class CreateReactionResponse(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("emote_id")
    val emoteId: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("user")
    val user: User
)
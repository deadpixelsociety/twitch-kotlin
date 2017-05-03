package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName
import com.thedeadpixelsociety.twitch.api.users.User

data class Reason(
    @SerializedName("type")
    val type: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("created_at")
    val createdAt: String
)
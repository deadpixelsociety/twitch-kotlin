package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName
import com.thedeadpixelsociety.twitch.api.UserIds

data class Reaction(
    @SerializedName("count")
    val count: Int,
    @SerializedName("emote")
    val emote: String,
    @SerializedName("user_ids")
    val userIds: UserIds
)

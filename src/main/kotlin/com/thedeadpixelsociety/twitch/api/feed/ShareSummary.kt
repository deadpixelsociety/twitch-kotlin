package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName
import com.thedeadpixelsociety.twitch.api.UserIds

data class ShareSummary(
    @SerializedName("users")
    val users: UserIds,
    @SerializedName("share_count")
    val count: Int
)
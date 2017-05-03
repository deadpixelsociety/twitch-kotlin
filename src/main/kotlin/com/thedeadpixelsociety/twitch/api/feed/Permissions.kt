package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName

data class Permissions(
    @SerializedName("can_delete")
    val delete: Boolean,
    @SerializedName("can_moderate")
    val moderate: Boolean,
    @SerializedName("can_reply")
    val reply: Boolean,
    @SerializedName("can_reply_reason")
    val replyReason: String? = null
)
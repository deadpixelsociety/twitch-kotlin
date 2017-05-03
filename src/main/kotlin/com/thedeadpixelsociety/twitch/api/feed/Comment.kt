package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName
import com.thedeadpixelsociety.twitch.api.EmoteReplacements
import com.thedeadpixelsociety.twitch.api.users.User

data class Comment(
    @SerializedName("id")
    val id: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted")
    val deleted: Boolean,
    @SerializedName("emotes")
    val emotes: EmoteReplacements,
    @SerializedName("permissions")
    val permissions: Permissions,
    @SerializedName("reactions")
    val reactions: Reactions,
    @SerializedName("user")
    val user: User,
    @SerializedName("needs_approval")
    val needsApproval: Boolean
)
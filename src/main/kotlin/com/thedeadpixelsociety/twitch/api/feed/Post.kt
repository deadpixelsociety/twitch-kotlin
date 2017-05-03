package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName
import com.thedeadpixelsociety.twitch.api.EmoteReplacements
import com.thedeadpixelsociety.twitch.api.users.User

data class Post(
    @SerializedName("body")
    val body: String,
    @SerializedName("comments")
    val comments: CommentsResponse,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted")
    val deleted: Boolean,
    @SerializedName("emotes")
    val emotes: EmoteReplacements,
    @SerializedName("id")
    val id: String,
    @SerializedName("permissions")
    val permissions: Permissions,
    @SerializedName("reactions")
    val reactions: Reactions,
    @SerializedName("user")
    val user: User,
    @SerializedName("share_summary")
    val shareSummary: ShareSummary,
    @SerializedName("reasons")
    val reasons: Reasons
)
package com.thedeadpixelsociety.twitch.api.users

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("_id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("logo")
    val logo: String
)
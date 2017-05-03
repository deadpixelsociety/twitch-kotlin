package com.thedeadpixelsociety.twitch.api.channels

import com.google.gson.annotations.SerializedName

data class Channel(
    @SerializedName("mature")
    val mature: Boolean,
    @SerializedName("status")
    val status: String?,
    @SerializedName("broadcaster_language")
    val broadcasterLanguage: String,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("game")
    val game: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("_id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("partner")
    val partner: Boolean,
    @SerializedName("logo")
    val logo: String?,
    @SerializedName("video_banner")
    val videoBanner: String?,
    @SerializedName("profile_banner")
    val profileBanner: String?,
    @SerializedName("profile_banner_background_color")
    val profileBannerBackgroundColor: String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("views")
    val views: Int,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("broadcaster_type")
    val broadcasterType: String,
    @SerializedName("stream_key")
    val streamKey: String,
    @SerializedName("email")
    val email: String?
)
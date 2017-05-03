package com.thedeadpixelsociety.twitch.api.bits

import com.google.gson.annotations.SerializedName

data class Tier(
    @SerializedName("color")
    val color: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: Images,
    @SerializedName("min_bits")
    val minBits: Int
)
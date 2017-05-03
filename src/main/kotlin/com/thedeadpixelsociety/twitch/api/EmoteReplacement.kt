package com.thedeadpixelsociety.twitch.api

import com.google.gson.annotations.SerializedName

data class EmoteReplacement(
    @SerializedName("id")
    val id: Long,
    @SerializedName("start")
    val start: Int,
    @SerializedName("end")
    val end: Int,
    @SerializedName("set")
    val set: Long
)
package com.thedeadpixelsociety.twitch.api.bits

import com.google.gson.annotations.SerializedName

data class Action(
    @SerializedName("backgrounds")
    val backgrounds: Backgrounds,
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("scales")
    val scales: Scales,
    @SerializedName("states")
    val states: States,
    @SerializedName("tiers")
    val tiers: Tiers
)
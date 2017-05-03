package com.thedeadpixelsociety.twitch.api.bits

import com.google.gson.annotations.SerializedName

data class CheermotesResponse(
    @SerializedName("actions")
    val actions: Actions
)
package com.thedeadpixelsociety.twitch.api.bits

import com.google.gson.annotations.SerializedName

/**
 * Defines the main response body of the bits/actions endpoint.
 */
data class BitsResponse(
    /**
     * A list of available bit actions.
     */
    @SerializedName("actions")
    val actions: List<BitsAction>
)
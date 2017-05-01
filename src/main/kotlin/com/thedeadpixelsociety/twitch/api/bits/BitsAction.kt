package com.thedeadpixelsociety.twitch.api.bits

import com.google.gson.annotations.SerializedName

/**
 * Defines an 'action' of the 'actions' section of the bits/actions endpoint response.
 */
data class BitsAction(
    /**
     * A list of available cheer backgrounds. See [BitsImages].
     */
    @SerializedName("backgrounds")
    val backgrounds: List<String>,
    /**
     * The cheer prefix.
     */
    @SerializedName("prefix")
    val prefix: String,
    /**
     * A list of available cheer scales. See [BitsImages].
     */
    @SerializedName("scales")
    val scales: List<String>,
    /**
     * A list of available cheer states. See [BitsImages].
     */
    @SerializedName("states")
    val states: List<String>,
    /**
     * A list of available cheer tiers.
     */
    @SerializedName("tiers")
    val tiers: List<BitsTier>
)
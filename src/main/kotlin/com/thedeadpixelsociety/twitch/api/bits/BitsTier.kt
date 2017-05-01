package com.thedeadpixelsociety.twitch.api.bits

import com.google.gson.annotations.SerializedName

/**
 * Defines a 'tier' of the 'tiers' section of the bits/actions endpoint response.
 */
data class BitsTier(
    /**
     * The color of the bits tier as a hexadecimal color. Prefixed by a hash (#).
     */
    @SerializedName("color")
    val color: String,
    /**
     * The ID of the bits tier.
     */
    @SerializedName("id")
    val id: String,
    /**
     * The images mapping of the bits tier. See [BitsImages].
     */
    @SerializedName("images")
    val images: BitsImages,
    /**
     * The minimum bits amount for the tier.
     */
    @SerializedName("min_bits")
    val minBits: Int
)
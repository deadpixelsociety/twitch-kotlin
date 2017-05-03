package com.thedeadpixelsociety.twitch.api

/**
 * Defines a Twitch error message.
 */
data class ErrorResponse(
    /**
     * The error message, if any.
     */
    val message: String?,
    /**
     * The error status code. Uses standard HTTP error codes.
     */
    val status: Int,
    /**
     * The error description, if any.
     */
    val error: String?
)
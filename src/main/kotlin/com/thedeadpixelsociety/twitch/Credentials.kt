package com.thedeadpixelsociety.twitch

/**
 * Twitch API credentials.
 * @param clientId The app client ID as registered on Twitch.
 * @param accessToken The app access token as granted by the authorization flow.
 */
data class Credentials(
    /**
     * The app client ID as registered on Twitch.
     */
    val clientId: String,
    /**
     * The app access token as granted by the authorization flow.
     */
    val accessToken: String
)
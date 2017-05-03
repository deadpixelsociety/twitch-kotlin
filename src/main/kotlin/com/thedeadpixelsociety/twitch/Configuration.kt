package com.thedeadpixelsociety.twitch

/**
 * Twitch API configuration values.
 * @param rootUrl The root API URL. Defaults to [DEFAULT_ROOT_URL].
 * @param version The API version number. Defaults to [DEFAULT_VERSION].
 */
data class Configuration(
    /**
     * The root API URL.
     */
    val rootUrl: String = Configuration.DEFAULT_ROOT_URL,
    /**
     * The API version number.
     */
    val version: Int = Configuration.DEFAULT_VERSION
) {
    companion object {
        /**
         * The default root API url: https://api.twitch.tv/kraken
         */
        const val DEFAULT_ROOT_URL = "https://api.twitch.tv/kraken/"
        /**
         * The default API version: 5
         */
        const val DEFAULT_VERSION = 5
    }
}
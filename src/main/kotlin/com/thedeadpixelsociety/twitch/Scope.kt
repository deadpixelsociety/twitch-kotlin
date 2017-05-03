package com.thedeadpixelsociety.twitch

/**
 * Enumerates the available Twitch API scopes. See https://dev.twitch.tv/docs/v5/guides/authentication/ for more info.
 */
enum class Scope(val scopeName: String) {
    /**
     * Read whether a user is subscribed to your channel.
     */
    CHANNEL_CHECK_SUBSCRIPTION("channel_check_subscription"),
    /**
     * Triggers commercials on channel.
     */
    CHANNEL_COMMERCIAL("channel_commercial"),
    /**
     * Write channel metadata (game, status, etc).
     */
    CHANNEL_EDITOR("channel_editor"),
    /**
     * Add posts and reactions to channel feed.
     */
    CHANNEL_FEED_EDIT("channel_feed_edit"),
    /**
     * View a channel feed.
     */
    CHANNEL_FEED_READ("channel_feed_read"),
    /**
     * Read nonpublic channel information, including email address and stream key.
     */
    CHANNEL_READ("channel_read"),
    /**
     * Reset a channel’s stream key.
     */
    CHANNEL_STREAM("channel_stream"),
    /**
     * Read all subscribers to your channel.
     */
    CHANNEL_SUBSCRIPTIONS("channel_subscriptions"),
    /**
     * Log into chat and send messages.
     */
    CHAT_LOGIN("chat_login"),
    /**
     * Manage a user’s collections (of videos).
     */
    COLLECTIONS_EDIT("collections_edit"),
    /**
     * Manage a user’s communities.
     */
    COMMUNITIES_EDIT("communities_edit"),
    /**
     * Manage community moderators.
     */
    COMMUNITIES_MODERATE("communities_moderate"),
    /**
     * Turn on/off ignoring a user. Ignoring a user means you cannot see him type, receive messages from him, etc.
     */
    USER_BLOCKS_EDIT("user_blocks_edit"),
    /**
     * Read a user’s list of ignored users.
     */
    USER_BLOCKS_READ("user_blocks_read"),
    /**
     * Manage a user’s followed channels.
     */
    USER_FOLLOWERS_EDIT("user_followers_edit"),
    /**
     * Read nonpublic user information, like email address.
     */
    USER_READ("user_read"),
    /**
     * Read a user’s subscriptions.
     */
    USER_SUBSCRIPTIONS("user_subscriptions"),
    /**
     * Turn on Viewer Heartbeat Service ability to record user data.
     */
    VIEWING_ACTIVITY_READ("viewing_activity_read");

    companion object {
        /**
         * Returns the [Scope] that matches the specified scope name, if any.
         * @param scopeName The scope name.
         * @return The matching [Scope], if any; otherwise, null.
         */
        fun byScopeName(scopeName: String) = Scope.values().firstOrNull { it.scopeName == scopeName }
    }
}
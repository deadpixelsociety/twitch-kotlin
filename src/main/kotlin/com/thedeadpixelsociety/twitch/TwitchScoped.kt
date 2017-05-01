package com.thedeadpixelsociety.twitch

/**
 * Annotation that defines required Twitch scopes on a per-function basis. Not having the required scope should cause
 * the function to fail.
 * @param scope The required [TwitchScope].
 * @param additional Additional required scopes beyond the first.
 */
@Target(AnnotationTarget.FUNCTION)
annotation class TwitchScoped(
    /**
     * The required [TwitchScope].
     */
    val scope: TwitchScope,
    /**
     * Additional required scopes beyond the first.
     */
    vararg val additional: TwitchScope
)
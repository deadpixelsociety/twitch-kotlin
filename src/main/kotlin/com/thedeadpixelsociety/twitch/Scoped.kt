package com.thedeadpixelsociety.twitch

/**
 * Annotation that defines required Twitch scopes on a per-function basis. Not having the required scope should cause
 * the function to fail.
 * @param scope The required [Scope].
 * @param additional Additional required scopes beyond the first.
 */
@Target(AnnotationTarget.FUNCTION)
annotation class Scoped(
    /**
     * The required [Scope].
     */
    val scope: Scope,
    /**
     * Additional required scopes beyond the first.
     */
    vararg val additional: Scope
)
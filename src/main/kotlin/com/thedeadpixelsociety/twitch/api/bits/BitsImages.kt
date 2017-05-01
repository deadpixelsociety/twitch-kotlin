package com.thedeadpixelsociety.twitch.api.bits

/**
 * Defines the 'images' section of the bits/actions endpoint response as a mapping of backgrounds -> states -> scales
 * -> URLs.
 */
class BitsImages : HashMap<String, Map<String, Map<String, String>>>()
package com.thedeadpixelsociety.twitch.api

import com.thedeadpixelsociety.twitch.TwitchClient
import com.thedeadpixelsociety.twitch.Credentials

abstract class ApiTest {
    val credentials by lazy { Credentials("uo6dggojyb8d6soh92zknwmi5ej1q2", "pk2bh6y1vi8mrn7l67bp9i6dpg2wnk") }
    val client by lazy { TwitchClient.createDefault(credentials) }
}
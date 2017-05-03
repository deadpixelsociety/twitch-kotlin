package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName

data class BodyContent(@SerializedName("content") val content: String)
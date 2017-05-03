package com.thedeadpixelsociety.twitch.api.feed

import com.google.gson.annotations.SerializedName

data class DeleteReactionResponse(@SerializedName("deleted") val deleted: Boolean)
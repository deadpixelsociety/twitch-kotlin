package com.thedeadpixelsociety.twitch.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * Helper object for working with JSON.
 */
object Json {
    private val gson: Gson by lazy { GsonBuilder().create() }

    /**
     * Decodes the specified JSON string into a concrete object.
     * @param T The object type.
     * @param json The JSON string.
     * @param targetClass The target class.
     * @return The created object, if possible; otherwise, null.
     */
    fun <T> decode(json: String?, targetClass: Class<T>): T? {
        try {
            if (json.isNullOrEmpty()) return null
            return gson.fromJson(json, targetClass)
        } catch (ex: Exception) {
            // TODO: Logging
            ex.printStackTrace()
            return null
        }
    }

    /**
     * Decodes the specified JSON string into a concrete object.
     * @param T The object type.
     * @param json The JSON string.
     * @return The created object, if possible; otherwise, null.
     */
    inline fun <reified T> decode(json: String?): T? = decode(json, T::class.java)

    /**
     * Encodes the specified object as a JSON string.
     * @param target The object to encode.
     * @return The encoded JSON string, if possible; otherwise, null.
     */
    fun encode(target: Any): String? {
        try {
            return gson.toJson(target)
        } catch (ex: Exception) {
            // TODO: Logging
            ex.printStackTrace()
            return null
        }
    }
}
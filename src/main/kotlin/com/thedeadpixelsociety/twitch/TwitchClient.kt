package com.thedeadpixelsociety.twitch

import com.thedeadpixelsociety.twitch.api.Endpoint
import com.thedeadpixelsociety.twitch.api.bits.Bits
import com.thedeadpixelsociety.twitch.api.feed.Feed
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException

open class TwitchClient(val config: Configuration, val credentials: Credentials) {
    companion object {
        const val HEADER_ACCEPT = "Accept"
        const val HEADER_CLIENT_ID = "Client-ID"
        const val HEADER_AUTHORIZATION = "Authorization"

        fun createDefault(credentials: Credentials): TwitchClient {
            return create(Configuration(), credentials, Bits(), Feed())
        }

        fun create(config: Configuration, credentials: Credentials, vararg endpoints: Endpoint): TwitchClient {
            return TwitchClient(config, credentials).apply {
                addAll(endpoints.toList())
                init()
            }
        }
    }

    private val retrofit by lazy { buildRetrofit() }
    private val endpoints = hashMapOf<Class<*>, Endpoint>()

    fun add(endpoint: Endpoint, vararg additional: Endpoint): TwitchClient {
        endpoints.put(endpoint.javaClass, endpoint)
        additional.forEach { endpoints.put(it.javaClass, it) }
        return this
    }

    fun addAll(endpoints: Collection<Endpoint>): TwitchClient {
        endpoints.forEach { this.endpoints.put(it.javaClass, it) }
        return this
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> get(endpointClass: Class<T>): T {
        return endpoints[endpointClass] as? T
            ?: throw IllegalStateException("Endpoint ${endpointClass.name} not registered.")
    }

    inline fun <reified T> get(): T = get(T::class.java)

    fun init() {
        endpoints.values.forEach { it.init(retrofit) }
    }

    protected open fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(TwitchInterceptor(config, credentials)).build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(config.rootUrl)
            .build()
    }

    open class TwitchInterceptor(val config: Configuration, val credentials: Credentials) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .addHeader(HEADER_ACCEPT, buildAcceptValue())
                .addHeader(HEADER_CLIENT_ID, credentials.clientId)

            if (!credentials.accessToken.isNullOrEmpty())
                request.addHeader(HEADER_AUTHORIZATION, buildOAuthValue())

            return chain.proceed(request.build())
        }

        protected open fun buildAcceptValue() = "application/vnd.twitchtv.v${config.version}+json"

        protected open fun buildOAuthValue() = "OAuth ${credentials.accessToken}"
    }
}
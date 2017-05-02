package com.thedeadpixelsociety.twitch

import com.thedeadpixelsociety.twitch.api.TwitchEndpoint
import com.thedeadpixelsociety.twitch.api.bits.Bits
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException

open class TwitchClient(val config: TwitchConfig, val credentials: TwitchCredentials) {
    companion object {
        const val HEADER_ACCEPT = "Accept"
        const val HEADER_CLIENT_ID = "Client-ID"
        const val HEADER_AUTHORIZATION = "Authorization"

        fun createDefault(credentials: TwitchCredentials): TwitchClient {
            return create(TwitchConfig(), credentials, Bits())
        }

        fun create(config: TwitchConfig, credentials: TwitchCredentials, vararg endpoints: TwitchEndpoint): TwitchClient {
            return TwitchClient(config, credentials).apply {
                addAll(endpoints.toList())
                init()
            }
        }
    }

    private val retrofit by lazy { buildRetrofit() }
    private val endpoints = hashMapOf<Class<*>, TwitchEndpoint>()

    fun add(endpoint: TwitchEndpoint, vararg additional: TwitchEndpoint): TwitchClient {
        endpoints.put(endpoint.javaClass, endpoint)
        additional.forEach { endpoints.put(it.javaClass, it) }
        return this
    }

    fun addAll(endpoints: Collection<TwitchEndpoint>): TwitchClient {
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

    open class TwitchInterceptor(val config: TwitchConfig, val credentials: TwitchCredentials) : Interceptor {
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
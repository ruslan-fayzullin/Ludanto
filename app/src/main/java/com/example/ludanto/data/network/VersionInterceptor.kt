package com.example.ludanto.data.network

import com.example.ludanto.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class VersionInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url
        val url = originalUrl.newBuilder()
            .addQueryParameter(ARG_VERSION, BuildConfig.API_VERSION)
            .build()
        val request = original.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }

    companion object {
        private const val ARG_VERSION = "v"
    }
}
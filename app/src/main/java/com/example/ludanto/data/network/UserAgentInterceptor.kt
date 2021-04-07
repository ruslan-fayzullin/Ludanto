package com.example.ludanto.data.network

import com.example.ludanto.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class UserAgentInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = original.newBuilder()
            .addHeader(ARG_USER_AGENT, BuildConfig.USER_AGENT)
            .build()

        return chain.proceed(request)
    }

    companion object {
        const val ARG_USER_AGENT = "User-Agent"
    }
}
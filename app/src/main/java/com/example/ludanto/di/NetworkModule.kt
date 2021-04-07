package com.example.ludanto.di

import com.example.ludanto.BuildConfig
import com.example.ludanto.data.network.Api
import com.example.ludanto.data.network.UserAgentInterceptor
import com.example.ludanto.data.network.VersionInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson().newBuilder()
        .create()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        versionInterceptor: VersionInterceptor,
        userAgentInterceptor: UserAgentInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(versionInterceptor)
        .addInterceptor(userAgentInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofitClient(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BuildConfig.VK_API_BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideVkApiService(retrofit: Retrofit) =
        retrofit.create(Api::class.java)

}
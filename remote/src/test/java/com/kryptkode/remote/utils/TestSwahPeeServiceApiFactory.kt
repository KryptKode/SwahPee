package com.kryptkode.remote.utils

import com.kryptkode.remote.api.SwahPeeServiceApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object TestSwahPeeServiceApiFactory {

    fun makeSwahPeeService(mockWebServer: MockWebServer): SwahPeeServiceApi {
        return makeSwahPeeService(mockWebServer, makeOkHttpClient(makeLoggingInterceptor()))
    }

    private fun makeSwahPeeService(mockWebServer: MockWebServer, okHttpClient: OkHttpClient): SwahPeeServiceApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        return retrofit.create(SwahPeeServiceApi::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        return logging
    }
}
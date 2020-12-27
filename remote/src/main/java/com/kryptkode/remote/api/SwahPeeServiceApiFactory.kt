package com.kryptkode.remote.api

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object SwahPeeServiceApiFactory {

    fun makeSwahPeeService(moshi: Moshi, isDebug: Boolean): SwahPeeServiceApi {
        val okHttpClient = makeOkHttpClient(
                makeLoggingInterceptor((isDebug)))
        return makeSwahPeeService(okHttpClient, moshi)
    }

    private fun makeSwahPeeService(okHttpClient: OkHttpClient, moshi: Moshi): SwahPeeServiceApi {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        return retrofit.create(SwahPeeServiceApi::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }
}
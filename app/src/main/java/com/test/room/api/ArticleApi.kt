package com.test.room.api

import android.util.Log
import com.test.room.api.model.ArticleResponse
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ArticleApi {

    @GET("/v2/everything?q=sports&apiKey=aa67d8d98c8e4ad1b4f16dbd5f3be348")
    suspend fun getArticles(): ArticleResponse

    companion object {
        private const val BASE_URL = "https://newsapi.org"
        fun create(): ArticleApi {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Log.d("API", it) })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(HttpUrl.parse(BASE_URL)!!)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ArticleApi::class.java)
        }
    }
}
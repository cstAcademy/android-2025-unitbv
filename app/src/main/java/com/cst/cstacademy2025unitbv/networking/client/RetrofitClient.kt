package com.cst.cstacademy2025unitbv.networking.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private val logging = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    val instance = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
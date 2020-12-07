package com.example.detikcom.service

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

object RetrofitBuilder {

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(TopHeadLines::class.java)
}
interface TopHeadLines{
    @Headers("Authorization: 82a0eae9555d4dbdbf7f0dfc1cb564c6")
    @GET("v2/top-headlines?country=id")

    fun feachHeadLine(): retrofit2.Call<com.example.detikcom.model.Response>
}
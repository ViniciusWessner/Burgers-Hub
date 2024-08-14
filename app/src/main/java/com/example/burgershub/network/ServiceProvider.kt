package com.example.burgershub.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


class ServiceProvider {
    private val baseUrl = ""
    private val client = OkHttpClient.Builder()  //pega as chamadas e coloca em log
        .connectTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()


    var retrofit: Retrofit = Retrofit.Builder() //faz as requisicoes na API
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun<API> createService(apiClass: Class<API>): API = retrofit.create(apiClass)
}

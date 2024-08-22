package com.example.burgershub.network

import android.content.Context
import io.github.brunogabriel.mockpinterceptor.MockPInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class ServiceProvider @Inject constructor(context: Context) {
    private val baseUrl = "https://burgers-hub.p.rapidapi.com/"


    // Create interceptor
   private val mockpInterceptor = MockPInterceptor
        .Builder(context)
        .addDelayInMillis(5_000L, 10_000L)
        .build()

    private val client = OkHttpClient.Builder()  //pega as chamadas e coloca em log
        .connectTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(Interceptor{ chain ->
            chain.run {
                proceed(
                    request()
                        .newBuilder()
                        .addHeader(
                            "x-rapidapi-key",
                            "50a89bd841msh213cdaff04a3525p18b6c0jsn7dee06b426da"
                        )
                        .build()
                )
            }
        })
        .addInterceptor(mockpInterceptor)
        .build()


    var retrofit: Retrofit = Retrofit.Builder() //faz as requisicoes na API
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun<API> createService(apiClass: Class<API>): API = retrofit.create(apiClass)
}

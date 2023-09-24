package com.nazlican.sisterslabproject.di

import com.nazlican.sisterslabproject.data.network.ProductApi
import com.nazlican.sisterslabproject.util.Constants.BASE_URL
import com.nazlican.sisterslabproject.util.Constants.STORE
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitModule {

    fun getInterceptor(): Interceptor {
        return Interceptor {
            val request = it.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("store", STORE).build()

            it.proceed(request)
        }
    }

    fun getOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
        return httpBuilder
            .protocols(mutableListOf(Protocol.HTTP_1_1))
            .build()
    }

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getOkHttpClient(getInterceptor()))
        .build()
        .create(ProductApi::class.java)

    //fun provideProductAppService(retrofit: Retrofit): ProductApi {
    //    return retrofit.create(ProductApi::class.java)
    //}
}
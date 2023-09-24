package com.nazlican.sisterslabproject.data.repo

import com.nazlican.sisterslabproject.data.model.Detail
import com.nazlican.sisterslabproject.data.model.Product
import com.nazlican.sisterslabproject.di.RetrofitModule
import retrofit2.Response
import retrofit2.http.Query

class ProductRepository {

    val retrofitModule = RetrofitModule()

    suspend fun getProduct(): Response<Product> = retrofitModule.retrofit.getProduct()

    suspend fun detailProduct(@Query("id") id: Int): Response<Detail> =  retrofitModule.retrofit.detailProduct(id)

    suspend fun getCardProduct(): Response<Product> = retrofitModule.retrofit.getCartProduct()
}
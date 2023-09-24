package com.nazlican.sisterslabproject.data.repo

import com.nazlican.sisterslabproject.data.model.Product
import com.nazlican.sisterslabproject.di.RetrofitModule
import retrofit2.Response

class ProductRepository {

    val retrofitModule = RetrofitModule()

    suspend fun getProduct(): Response<Product> = retrofitModule.retrofit.getProduct()
}
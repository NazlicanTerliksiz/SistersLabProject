package com.nazlican.sisterslabproject.data.repo

import com.nazlican.sisterslabproject.data.model.AddToCart
import com.nazlican.sisterslabproject.data.model.DeleteFromCart
import com.nazlican.sisterslabproject.data.model.Detail
import com.nazlican.sisterslabproject.data.model.Product
import com.nazlican.sisterslabproject.di.RetrofitModule
import retrofit2.Response

class ProductRepository {

    val retrofitModule = RetrofitModule()

    suspend fun getProduct(): Response<Product> = retrofitModule.retrofit.getProduct()

    suspend fun detailProduct(id: Int): Response<Detail> =  retrofitModule.retrofit.detailProduct(id)

    suspend fun getCardProduct(): Response<Product> = retrofitModule.retrofit.getCartProduct()

    suspend fun addToCart(addToCart: AddToCart): Response<AddToCart> = retrofitModule.retrofit.addToCart(addToCart)

    suspend fun deleteFromCart(deleteFromCart: DeleteFromCart): Response<DeleteFromCart> = retrofitModule.retrofit.deleteFromCart(deleteFromCart)

    suspend fun searchFromProduct(query: String): Response<Product> = retrofitModule.retrofit.searchFromProduct(query)
}
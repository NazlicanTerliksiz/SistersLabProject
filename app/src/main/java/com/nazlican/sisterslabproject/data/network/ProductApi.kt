package com.nazlican.sisterslabproject.data.network

import com.nazlican.sisterslabproject.data.model.Detail
import com.nazlican.sisterslabproject.data.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi{
    @GET("get_products.php")
    suspend fun getProduct(): Response<Product>

    @GET("get_product_detail.php")
    suspend fun detailProduct(
        @Query("id") id: Int
    ): Response<Detail>

    @GET("get_cart_products.php?userId=b3sa6dj721312ssadas21d")
    suspend fun getCartProduct(): Response<Product>

}

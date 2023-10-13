package com.nazlican.sisterslabproject.data.repo

import com.nazlican.sisterslabproject.data.model.AddToCart
import com.nazlican.sisterslabproject.data.model.DeleteFromCart
import com.nazlican.sisterslabproject.data.model.Detail
import com.nazlican.sisterslabproject.data.model.Product
import com.nazlican.sisterslabproject.data.model.ProductX
import com.nazlican.sisterslabproject.di.RetrofitModule
import com.nazlican.sisterslabproject.room.Database
import retrofit2.Response
import javax.inject.Inject
class ProductRepository (private var retrofitModule: RetrofitModule,private val database : Database){

    suspend fun getProduct(): Response<Product> = retrofitModule.retrofit.getProduct()

    suspend fun detailProduct(id: Int): Response<Detail> =  retrofitModule.retrofit.detailProduct(id)

    suspend fun getCardProduct(): Response<Product> =  retrofitModule.retrofit.getCartProduct()

    suspend fun addToCart(addToCart: AddToCart): Response<AddToCart> =  retrofitModule.retrofit.addToCart(addToCart)

    suspend fun deleteFromCart(deleteFromCart: DeleteFromCart): Response<DeleteFromCart> = retrofitModule.retrofit.deleteFromCart(deleteFromCart)

    suspend fun searchFromProduct(query: String): Response<Product> = retrofitModule.retrofit.searchFromProduct(query)
    suspend fun getFavorites() : List<ProductX> = database.getfavoritesDao().getFavorites()
    suspend fun addToFavorite(productX: ProductX) = database.getfavoritesDao().addToFavorite(productX)
    suspend fun deleteFromFavorites(id: Int) = database.getfavoritesDao().deleteFromFavorites(id)



}
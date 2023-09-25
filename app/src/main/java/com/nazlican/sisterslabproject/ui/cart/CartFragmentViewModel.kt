package com.nazlican.sisterslabproject.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlican.sisterslabproject.data.model.DeleteFromCart
import com.nazlican.sisterslabproject.data.model.ProductX
import com.nazlican.sisterslabproject.data.repo.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CartFragmentViewModel: ViewModel(){

    private var job: Job? = null

    val cartLiveData = MutableLiveData<List<ProductX>?>()
    val deleteLiveData = MutableLiveData<DeleteFromCart?>()
    private val productRepository = ProductRepository()


    fun cartProducts() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val result =productRepository.getCardProduct()
            if (result.isSuccessful) {
                result.body()?.let {cartProductList ->
                    cartLiveData.postValue(cartProductList.products)
                }
            }else{
                cartLiveData.postValue(null)
            }
        }
    }

    fun deleteFromCart(deleteFromCart: DeleteFromCart) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val result =productRepository.deleteFromCart(deleteFromCart)
            if (result.isSuccessful) {
                result.body()?.let {cartProductList ->
                    cartProducts()
                    deleteLiveData.postValue(result.body())
                }
            }else{
                deleteLiveData.postValue(null)
            }
        }
    }

}
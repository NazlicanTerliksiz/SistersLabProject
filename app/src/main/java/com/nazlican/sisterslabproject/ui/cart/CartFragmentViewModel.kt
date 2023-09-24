package com.nazlican.sisterslabproject.ui.cart

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlican.sisterslabproject.data.model.ProductX
import com.nazlican.sisterslabproject.data.repo.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CartFragmentViewModel: ViewModel(){

    private var job: Job? = null

    val cartLiveData = MutableLiveData<List<ProductX>?>()
    private val productRepository = ProductRepository()


    fun cartProducts() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val result =productRepository.getCardProduct()
            if (result.isSuccessful) {
                result.body()?.let {cartProductList ->
                    Log.d("if içi", cartProductList.toString())
                    cartLiveData.postValue(cartProductList.products)
                }
            }else{
                cartLiveData.postValue(null)
            }
        }
    }

}
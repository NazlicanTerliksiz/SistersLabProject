package com.nazlican.sisterslabproject.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlican.sisterslabproject.data.model.AddToCart
import com.nazlican.sisterslabproject.data.model.ProductXX
import com.nazlican.sisterslabproject.data.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
class DetailFragmentViewModel (var productRepository: ProductRepository) :
    ViewModel() {

    private var job: Job? = null

    val detailLiveData = MutableLiveData<ProductXX?>()
    var addCartLiveData = MutableLiveData<AddToCart?>()


    fun detailProducts(id: Int) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val result = productRepository.detailProduct(id)
            if (result.isSuccessful) {
                result.body()?.let { products ->
                    Log.d("if içi", products.toString())
                    detailLiveData.postValue(products.product)
                }
            } else {
                detailLiveData.postValue(null)
            }
        }
    }

    fun addToCart(addToCart: AddToCart) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val result = productRepository.addToCart(addToCart)
            if (result.isSuccessful) {
                result.body()?.let {
                    addCartLiveData.postValue(result.body())
                }
            } else {
                addCartLiveData.postValue(null)
            }
        }
    }

}
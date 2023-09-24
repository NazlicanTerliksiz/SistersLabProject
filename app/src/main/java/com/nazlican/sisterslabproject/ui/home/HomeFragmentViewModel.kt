package com.nazlican.sisterslabproject.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlican.sisterslabproject.data.model.ProductX
import com.nazlican.sisterslabproject.data.repo.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeFragmentViewModel : ViewModel() {

    private var job: Job? = null

    val productLiveData = MutableLiveData<List<ProductX>?>()
    val productRepository = ProductRepository()


    init {
        getProducts()
    }

    fun getProducts() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val result = productRepository.getProduct()
            if (result.isSuccessful) {
                result.body()?.let {productList ->
                    println("deneme $productList")
                    productLiveData.postValue(productList.products)
                }
            }
        }
    }
}

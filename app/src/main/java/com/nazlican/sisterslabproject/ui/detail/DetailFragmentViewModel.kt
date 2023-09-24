package com.nazlican.sisterslabproject.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlican.sisterslabproject.data.model.ProductXX
import com.nazlican.sisterslabproject.data.repo.ProductRepository
import com.nazlican.sisterslabproject.di.RetrofitModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailFragmentViewModel : ViewModel(){

    private var job: Job? = null

    val detailLiveData = MutableLiveData<ProductXX?>()
    val retrofitModule = RetrofitModule()
    val productRepository = ProductRepository()


    fun detailProducts(id:Int) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val result =productRepository.detailProduct(id)
            if (result.isSuccessful) {
                result.body()?.let {products ->
                 Log.d("if içi", products.toString())
                    detailLiveData.postValue(products.product)
                }
            }else{
                detailLiveData.postValue(null)
            }
        }
    }

}
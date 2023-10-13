package com.nazlican.sisterslabproject.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlican.sisterslabproject.data.model.DeleteFromCart
import com.nazlican.sisterslabproject.data.model.ProductX
import com.nazlican.sisterslabproject.data.repo.ProductRepository
import com.nazlican.sisterslabproject.room.FavoritesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavoriteFragmentViewModel (
    var productRepository: ProductRepository,

) : ViewModel() {

    private var job: Job? = null
    val favoriteLiveData = MutableLiveData<List<ProductX>?>()

    fun favoriteProducts() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val result = productRepository.getFavorites()
            if (result.isNotEmpty()) {
                favoriteLiveData.postValue(result)
            } else {
                favoriteLiveData.postValue(null)
            }
        }
    }
}

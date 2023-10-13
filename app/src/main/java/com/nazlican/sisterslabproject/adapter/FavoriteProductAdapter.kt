package com.nazlican.sisterslabproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlican.sisterslabproject.data.model.ProductX
import com.nazlican.sisterslabproject.databinding.CartCardDesignBinding
import com.nazlican.sisterslabproject.databinding.FavoriteCardDesignBinding
import com.nazlican.sisterslabproject.util.downloadFromUrl

class FavoriteProductAdapter (
):
    RecyclerView.Adapter<FavoriteProductAdapter.RowHolder>() {
    private val favoriteProductList = ArrayList<ProductX>()

    inner class RowHolder(private val binding: FavoriteCardDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteProduct: ProductX) {
            binding.apply {
                favoriteProductNameTv.text = favoriteProduct.title
                favoriteProductPriceTv.text = favoriteProduct.price.toString()
                favoriteProductIv.downloadFromUrl(favoriteProduct.imageOne)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding =
            FavoriteCardDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val cartProduct = favoriteProductList[position]
        holder.bind(cartProduct)
    }

    override fun getItemCount(): Int {
        return favoriteProductList.size
    }

    fun updateList(updateList:List<ProductX>){
        favoriteProductList.clear()
        favoriteProductList.addAll(updateList)
        notifyDataSetChanged()
    }

}
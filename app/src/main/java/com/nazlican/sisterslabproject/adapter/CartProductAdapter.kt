package com.nazlican.sisterslabproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlican.sisterslabproject.data.model.ProductX
import com.nazlican.sisterslabproject.databinding.CartCardDesignBinding
import com.nazlican.sisterslabproject.util.downloadFromUrl

class CartProductAdapter(
    private val cartProductList: List<ProductX>
    ):
    RecyclerView.Adapter<CartProductAdapter.RowHolder>() {

    inner class RowHolder(private val binding: CartCardDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cartProduct: ProductX) {
            binding.apply {
                bagProductNameTv.text = cartProduct.title
                bagProductPriceTv.text = cartProduct.price.toString()
                bagProductIv.downloadFromUrl(cartProduct.imageOne)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding =
            CartCardDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val cartProduct = cartProductList[position]
        holder.bind(cartProduct)
    }

    override fun getItemCount(): Int {
        return cartProductList.size
    }

}
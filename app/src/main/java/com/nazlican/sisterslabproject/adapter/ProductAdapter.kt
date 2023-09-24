package com.nazlican.sisterslabproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlican.sisterslabproject.data.model.ProductX
import com.nazlican.sisterslabproject.databinding.ProductCardDesignBinding
import com.nazlican.sisterslabproject.util.downloadFromUrl

class ProductAdapter(
    private val productList: List<ProductX>,
    private val onItemClickListener: (Int) -> Unit
) :
    RecyclerView.Adapter<ProductAdapter.RowHolder>() {

    inner class RowHolder(private val binding: ProductCardDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductX) {
            binding.apply {
                productTv.text = product.title
                priceTv.text = product.price.toString()
                productIv.downloadFromUrl(product.imageOne)
                root.setOnClickListener {
                    onItemClickListener.invoke(product.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding =
            ProductCardDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)

    }
}
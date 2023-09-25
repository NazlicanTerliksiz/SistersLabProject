package com.nazlican.sisterslabproject.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.nazlican.sisterslabproject.R
import com.nazlican.sisterslabproject.adapter.CartProductAdapter
import com.nazlican.sisterslabproject.common.viewBinding
import com.nazlican.sisterslabproject.data.model.DeleteFromCart
import com.nazlican.sisterslabproject.databinding.FragmentCartBinding

class CartFragment : Fragment(R.layout.fragment_cart) {

    private val binding by viewBinding(FragmentCartBinding::bind)
    private val viewModel: CartFragmentViewModel by lazy { CartFragmentViewModel() }
    private lateinit var adapter: CartProductAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cartProductRv.layoutManager = LinearLayoutManager(requireContext())
        adapter = CartProductAdapter(::deleteFromCart)
        binding.cartProductRv.adapter = adapter
        viewModel.cartProducts()
        observe()


    }

    private fun observe() {
        viewModel.cartLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.updateList(it)
            } else {
                Snackbar.make(requireView(), "list is empty", Snackbar.LENGTH_LONG).show()
            }
        }
        viewModel.deleteLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                Snackbar.make(requireView(), "Product deleted!", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(
                    requireView(),
                    "The product could not be deleted.",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun deleteFromCart(id:Int){
        viewModel.deleteFromCart(DeleteFromCart(id))
    }
}

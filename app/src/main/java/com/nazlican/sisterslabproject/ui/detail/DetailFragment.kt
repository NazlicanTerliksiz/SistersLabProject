package com.nazlican.sisterslabproject.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.nazlican.sisterslabproject.R
import com.nazlican.sisterslabproject.common.viewBinding
import com.nazlican.sisterslabproject.data.model.AddToCart
import com.nazlican.sisterslabproject.databinding.FragmentDetailBinding
import com.nazlican.sisterslabproject.util.downloadFromUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel: DetailFragmentViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.id

        Log.d("id", id.toString())
        viewModel.detailProducts(id)
        observe()

        binding.AddToCartbutton.setOnClickListener {
            viewModel.addToCart(AddToCart("b3sa6dj721312ssadas21d" ,id))
            cartObserve()
        }
    }
    private fun observe() {
        viewModel.detailLiveData.observe(viewLifecycleOwner) {
            if(it != null){
                binding.productDetailtv.text = it.title
                binding.descriptionTv.text = it.description
                binding.priceTv.text = it.price.toString()
                binding.productDetailIv.downloadFromUrl(it.imageOne)
            }else{
                Snackbar.make(requireView(), "liste boş", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    private fun cartObserve() {
        viewModel.addCartLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                findNavController().popBackStack()
            } else {
                Snackbar.make(requireView(), "Added to cart!", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}
package com.nazlican.sisterslabproject.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.nazlican.sisterslabproject.R
import com.nazlican.sisterslabproject.common.viewBinding
import com.nazlican.sisterslabproject.databinding.FragmentDetailBinding
import com.nazlican.sisterslabproject.util.downloadFromUrl


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel: DetailFragmentViewModel by lazy { DetailFragmentViewModel() }
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.id

        Log.d("id", id.toString())
        viewModel.detailProducts(id)
        observe()
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

}
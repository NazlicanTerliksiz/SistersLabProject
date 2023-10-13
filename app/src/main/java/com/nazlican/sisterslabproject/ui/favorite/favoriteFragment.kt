package com.nazlican.sisterslabproject.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.nazlican.sisterslabproject.R
import com.nazlican.sisterslabproject.adapter.CartProductAdapter
import com.nazlican.sisterslabproject.adapter.FavoriteProductAdapter
import com.nazlican.sisterslabproject.common.viewBinding
import com.nazlican.sisterslabproject.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

class favoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val binding by viewBinding(FragmentFavoriteBinding::bind)
    private val viewModel:FavoriteFragmentViewModel by viewModels()
    private lateinit var adapter: FavoriteProductAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.favoriteProductRv.layoutManager = LinearLayoutManager(requireContext())
        adapter = FavoriteProductAdapter()
        binding.favoriteProductRv.adapter = adapter
        viewModel.favoriteProducts()
        observe()
    }

    private fun observe() {
        viewModel.favoriteLiveData.observe(viewLifecycleOwner){
            if (it != null){
                adapter.updateList(it)
            }else{
                Snackbar.make(requireView(), "liste boş", Snackbar.LENGTH_LONG).show()
            }
        }
    }

}
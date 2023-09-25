package com.nazlican.sisterslabproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.nazlican.sisterslabproject.R
import com.nazlican.sisterslabproject.adapter.ProductAdapter
import com.nazlican.sisterslabproject.common.viewBinding
import com.nazlican.sisterslabproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private lateinit var adapter: ProductAdapter
    private val viewModel: HomeFragmentViewModel by lazy { HomeFragmentViewModel() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getProducts()
        search()
        observe()


        /*
        binding.ProductTil.setEndIconOnClickListener {
           hideSoftWareKeyBoard()
            if (binding.ProductTie.text.toString().isEmpty()) {
                viewModel.productLiveData
            } else {
                viewModel.getProducts(binding.ProductTie.text.toString())
            }
        }

         */


    }

    private fun observe() {
        viewModel.productLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter = ProductAdapter(it, ::homeToDetail)
                binding.productRv.adapter = adapter
                adapter.notifyDataSetChanged()
            } else {
                Snackbar.make(requireView(), "liste boş", Snackbar.LENGTH_LONG).show()
            }
        }
        viewModel.searchLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter = ProductAdapter(it, ::homeToDetail)
                binding.productRv.adapter = adapter
                adapter.notifyDataSetChanged()
            } else {
                Snackbar.make(requireView(), "liste boş", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun homeToDetail(id: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
        findNavController().navigate(action)
    }

    fun search() {
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchFromProduct(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchFromProduct(newText)
                return true
            }

        })
    }

    /*
    private fun hideSoftWareKeyBoard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.ProductTil.windowToken, 0)
    }
     */

}
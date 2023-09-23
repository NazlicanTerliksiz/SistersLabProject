package com.nazlican.sisterslabproject.view.bag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.nazlican.sisterslabproject.R
import com.nazlican.sisterslabproject.common.viewBinding
import com.nazlican.sisterslabproject.databinding.FragmentBagBinding

class BagFragment : Fragment(R.layout.fragment_bag) {

    private val binding by viewBinding(FragmentBagBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
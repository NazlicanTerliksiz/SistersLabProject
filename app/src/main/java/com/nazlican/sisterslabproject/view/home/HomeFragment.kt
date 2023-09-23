package com.nazlican.sisterslabproject.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.nazlican.sisterslabproject.R
import com.nazlican.sisterslabproject.common.viewBinding
import com.nazlican.sisterslabproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
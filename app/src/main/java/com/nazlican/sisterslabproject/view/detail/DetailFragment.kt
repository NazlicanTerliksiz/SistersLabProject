package com.nazlican.sisterslabproject.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nazlican.sisterslabproject.R
import com.nazlican.sisterslabproject.common.viewBinding
import com.nazlican.sisterslabproject.databinding.FragmentBagBinding
import com.nazlican.sisterslabproject.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
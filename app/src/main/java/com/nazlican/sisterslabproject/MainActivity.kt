package com.nazlican.sisterslabproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nazlican.sisterslabproject.common.viewBinding
import com.nazlican.sisterslabproject.databinding.ActivityMainBinding
import com.nazlican.sisterslabproject.databinding.FragmentBagBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
package com.example.navigationstudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.navigationstudy.databinding.FragmentHomeBinding
import com.example.navigationstudy.databinding.FragmentSecondScreenBinding


class SecondScreenFragment : Fragment() {
   private lateinit var binding: FragmentSecondScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second_screen, container, false)

        val input:String? = requireArguments().getString("name_input")
        binding.textView.text = input.toString()
        return binding.root
    }
}
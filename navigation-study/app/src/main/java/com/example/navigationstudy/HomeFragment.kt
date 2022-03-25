package com.example.navigationstudy

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationstudy.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        binding.submitButton.setOnClickListener {
            if(!TextUtils.isEmpty(binding.textName.text.toString())){
                val bundle: Bundle = bundleOf("name_input" to binding.textName.text.toString())
                it.findNavController().navigate(R.id.action_homeFragment_to_secondScreenFragment,args =  bundle)
            }else{
                Toast.makeText(activity,"Por favor, insira o seu nome", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}

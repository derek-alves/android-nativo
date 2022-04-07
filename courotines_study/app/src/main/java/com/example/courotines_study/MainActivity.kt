package com.example.courotines_study

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.courotines_study.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private suspend  fun downloadUserData() {
        withContext(Dispatchers.Main){
            for (i in 1..200000) {
                binding.tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
                delay(timeMillis = 100)
            }

        }

    }

}
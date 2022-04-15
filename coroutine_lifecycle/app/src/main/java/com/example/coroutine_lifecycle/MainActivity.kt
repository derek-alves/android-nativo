package com.example.coroutine_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.coroutine_lifecycle.databinding.MainActivityBinding
import com.example.coroutine_lifecycle.ui.main.MainFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        lifecycleScope.launch {
            binding.progressBar.visibility = View.VISIBLE
            delay(1000)
            binding.progressBar.visibility = View.GONE
        }

    }
}
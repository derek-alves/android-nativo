package com.example.coroutine_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.coroutine_lifecycle.databinding.MainActivityBinding
import com.example.coroutine_lifecycle.ui.main.MainFragment
import com.example.coroutine_lifecycle.ui.main.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

//        mainViewModel.getUsers() without live data needs to call
        mainViewModel.users.observe(this, Observer{ myUsers ->
            myUsers.forEach{
                Log.i("myTag", "name is ${it.name}")
            }
        })
        lifecycleScope.launch {
            binding.progressBar.visibility = View.VISIBLE
            delay(1000)
            binding.progressBar.visibility = View.GONE
        }

    }
}
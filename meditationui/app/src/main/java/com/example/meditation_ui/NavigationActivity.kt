package com.example.meditation_ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meditation_ui.databinding.ActivityNavigationBinding


class NavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
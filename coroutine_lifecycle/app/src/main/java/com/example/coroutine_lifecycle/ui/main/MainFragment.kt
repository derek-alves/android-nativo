package com.example.coroutine_lifecycle.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.coroutine_lifecycle.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getUsers()
        viewModel.usersWithoutLiveData.observe(viewLifecycleOwner, Observer { myUsers ->
            myUsers.forEach{
                Log.i("myTag", "name is ${it.name}")
            }
        })
        lifecycleScope.launch { }

        //will launch, when the activity or fragment created for the first time
        lifecycleScope.launchWhenCreated { }

        //will launch when the activity or fragment started
        lifecycleScope.launchWhenStarted {  }

        //running task just after the app is up and running
        lifecycleScope.launchWhenResumed {  }
    }



}
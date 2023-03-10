package com.example.dagger_hilt_study

import androidx.lifecycle.ViewModel
import com.example.dagger_hilt_study.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.Lazy
import javax.inject.Inject


@HiltViewModel
class DaggerHiltStudyViewModel @Inject constructor(private val repository: Lazy<Repository>) :
    ViewModel() {
        init {
            repository.get()
        }
}
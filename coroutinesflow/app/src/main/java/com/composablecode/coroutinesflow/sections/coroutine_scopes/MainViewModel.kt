package com.composablecode.coroutinesflow.sections.coroutine_scopes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    init {
        viewModelScope.launch {

        }
    }
}
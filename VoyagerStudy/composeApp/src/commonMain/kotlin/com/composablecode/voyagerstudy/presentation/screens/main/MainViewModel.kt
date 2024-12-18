package com.composablecode.voyagerstudy.presentation.screens.main

import androidx.compose.material.DrawerValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _drawerState = MutableStateFlow(DrawerValue.Closed)
    val drawerState: StateFlow<DrawerValue> = _drawerState.asStateFlow()

    fun switchDrawer() {
        _drawerState.value = when (_drawerState.value) {
            DrawerValue.Open -> DrawerValue.Closed
            DrawerValue.Closed -> DrawerValue.Open
        }
    }

    fun setDrawerState(drawerValue: DrawerValue) {
        _drawerState.value = drawerValue
    }

    fun closeDrawer() {
        _drawerState.value = DrawerValue.Closed
    }
}
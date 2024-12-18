package com.composablecode.voyagerstudy.presentation.screens.main

import androidx.compose.material.DrawerValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _drawerState = MutableStateFlow(DrawerValue.Closed)
    val drawerState: StateFlow<DrawerValue> = _drawerState

    fun switchDrawer() {
        _drawerState.value = when (_drawerState.value) {
            DrawerValue.Open -> DrawerValue.Closed
            DrawerValue.Closed -> DrawerValue.Open
        }
    }

    fun openDrawer() {
        _drawerState.value = DrawerValue.Open
    }

    fun closeDrawer() {
        _drawerState.value = DrawerValue.Closed
    }
}
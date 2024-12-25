package com.composablecode.voyagerstudy.presentation.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel() {
    private val _drawerState = MutableStateFlow(DrawerState.CLOSED)
    val drawerState: StateFlow<DrawerState> = _drawerState.asStateFlow()

    fun switchDrawer() {
        _drawerState.value = when (_drawerState.value) {
            DrawerState.OPEN -> DrawerState.CLOSED
            DrawerState.CLOSED -> DrawerState.OPEN
        }
    }

    fun setDrawerState(drawerState: DrawerState) {
        _drawerState.value = drawerState
    }
}

enum class DrawerState {
    OPEN, CLOSED
}
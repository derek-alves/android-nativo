package com.composablecode.voyagerstudy.utils

import androidx.compose.material.DrawerValue
import com.composablecode.voyagerstudy.presentation.viewModel.DrawerState

fun DrawerState.toDrawerValue(): DrawerValue {
    return when (this) {
        DrawerState.OPEN -> DrawerValue.Open
        DrawerState.CLOSED -> DrawerValue.Closed
    }
}
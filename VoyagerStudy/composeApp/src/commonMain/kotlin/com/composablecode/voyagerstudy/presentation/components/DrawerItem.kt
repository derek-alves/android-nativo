package com.composablecode.voyagerstudy.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DrawerItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    ListItem(
        text = { Text(tab.options.title) },
        icon = { Icon(tab.options.icon!!, contentDescription = null) },
        modifier = Modifier.clickable { tabNavigator.current = tab }
    )
}
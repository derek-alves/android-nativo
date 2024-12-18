package com.composablecode.voyagerstudy.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon

@Composable
fun DrawerMobile() {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // Account Info Section
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text("Eren Demir", style = MaterialTheme.typography.h6)
                Text("@erendmr", style = MaterialTheme.typography.body2)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("101 Following   321 Followers", style = MaterialTheme.typography.body2)

        Spacer(modifier = Modifier.height(24.dp))

        // Drawer Menu Items
        val menuItems = listOf(
            "Profile" to AppIcon.Profile,
            "Notifications" to AppIcon.Picture,
            "Discover" to AppIcon.Picture,
            "Messages" to AppIcon.Picture,
            "Bookmarks" to AppIcon.Picture,
            "Lists" to AppIcon.Picture,
            "More" to AppIcon.Picture
        )

        menuItems.forEach { (title, icon) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ButtonIcon(
                    icon = icon
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(title, style = MaterialTheme.typography.body1)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Log out", style = MaterialTheme.typography.body1)
    }
}
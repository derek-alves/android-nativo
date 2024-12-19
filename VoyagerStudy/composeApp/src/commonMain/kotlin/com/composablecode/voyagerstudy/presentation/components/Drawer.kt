package com.composablecode.voyagerstudy.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.Avatar
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon
import com.composablecode.voyagerstudy.designSystem.customColors
import com.composablecode.voyagerstudy.designSystem.spacings

@Composable
fun DrawerMobile(modifier: Modifier = Modifier, onClosePressed: () -> Unit) {
    val spacings = MaterialTheme.spacings()
    val colors = MaterialTheme.customColors()
    Column(
        modifier = modifier
            .fillMaxHeight().width(280.dp)
            .background(MaterialTheme.customColors().gray)
            .padding(spacings.lg),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Account Info",
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.SemiBold),
            )
            ButtonIcon(
                AppIcon.Close,
                onClick = {
                    onClosePressed.invoke()
                }
            )
        }
        Spacer(modifier = Modifier.height(spacings.xxl))
        Column(horizontalAlignment = Alignment.Start) {
            Avatar(imageUrl = "drawable/images/avatar-1.png")
            Spacer(modifier = Modifier.height(spacings.md))
            Column {
                Text("Eren Demir", style = MaterialTheme.typography.h3)
                Text("@erendmr", style = MaterialTheme.typography.h5.copy(color = colors.darkGray))
            }
        }

        Spacer(modifier = Modifier.height(spacings.xxl))
        Row(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacings().lg),
        ) {
            CounterItem(counter = 101, label = "Following")
            CounterItem(counter = 321, label = "Followers")
        }

        Spacer(modifier = Modifier.height(spacings.xxl))
        val menuItems = listOf(
            "Profile" to AppIcon.Profile,
            "Notifications" to AppIcon.Sign,
            "Discover" to AppIcon.Picture,
            "Messages" to AppIcon.Mail,
            "Bookmarks" to AppIcon.Save,
            "Lists" to AppIcon.Data,
            "More" to AppIcon.Dots
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
                Spacer(modifier = Modifier.width(spacings.lg))
                Text(title, style = MaterialTheme.typography.body1)
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Text("Log out", style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.SemiBold))
    }
}


@Composable
private fun CounterItem(counter: Int, label: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacings().xxs),
    ) {
        Text(
            counter.toString(),
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.SemiBold)
        )
        Text(
            label,
            style = MaterialTheme.typography.h5.copy(color = MaterialTheme.customColors().darkGray)
        )
    }
}
package com.example.meditation_ui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.meditation_ui.R
import com.example.meditation_ui.ui.theme.ButtonBlue
import com.example.meditation_ui.ui.theme.LightRed
import com.example.meditation_ui.ui.theme.TextWhite
import com.example.meditation_ui.ui.theme.sizes

@Composable
fun CurrentMeditation(
    title: String = "Daily Thought",
    description: String = "Meditation * 3-10 min",
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(RoundedCornerShape(MaterialTheme.sizes.medium))
            .background(color)
            .padding(
                horizontal =
                MaterialTheme.sizes.medium,
                vertical = MaterialTheme.sizes.extraMedium,
            )

            .fillMaxWidth()
    ) {
        Column() {
            Text(
                title,
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                color = TextWhite
            )
            Text(description, style = MaterialTheme.typography.body2, color = TextWhite)
        }

        Box(
            modifier = Modifier
                .size(MaterialTheme.sizes.extraLarge)
                .clip(CircleShape)
                .background(
                    ButtonBlue
                )

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier
                    .size(MaterialTheme.sizes.medium)
                    .align(Alignment.Center)
            )
        }

    }
}
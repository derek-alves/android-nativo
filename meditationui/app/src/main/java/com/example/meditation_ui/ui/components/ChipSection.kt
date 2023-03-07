package com.example.meditation_ui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.meditation_ui.ui.theme.ButtonBlue
import com.example.meditation_ui.ui.theme.DarkerButtonBlue
import com.example.meditation_ui.ui.theme.TextWhite
import com.example.meditation_ui.ui.theme.sizes

@Composable
fun ChipSection(chips: List<String>) {
    val mediumSize = MaterialTheme.sizes.medium;
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(count = chips.size) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(
                        end = mediumSize,
                        bottom = mediumSize
                    )
                    .clip(RoundedCornerShape(MaterialTheme.sizes.medium))
                    .background(if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .padding(mediumSize)
            ) {
                Text(
                    text = chips[it],
                    color = TextWhite,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}
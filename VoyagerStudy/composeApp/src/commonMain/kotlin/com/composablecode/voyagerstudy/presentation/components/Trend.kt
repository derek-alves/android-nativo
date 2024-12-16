package com.composablecode.voyagerstudy.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.composablecode.voyagerstudy.designSystem.customColors
import com.composablecode.voyagerstudy.designSystem.spacings
import com.composablecode.voyagerstudy.domain.entity.Trend

@Composable
fun TrendItem(trend: Trend) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacings().xxxs)
    ) {
        Text(
            trend.category,
            style = MaterialTheme.typography.h6.copy(color = MaterialTheme.customColors().darkGray)
        )
        Text(
            trend.title,
            style = MaterialTheme.typography.h5
        )
        Text(
            "${trend.counter} Tweets",
            style = MaterialTheme.typography.h6.copy(color = MaterialTheme.customColors().darkGray)
        )
    }
}
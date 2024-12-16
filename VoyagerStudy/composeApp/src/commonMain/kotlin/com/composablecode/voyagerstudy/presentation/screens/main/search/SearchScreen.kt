package com.composablecode.voyagerstudy.presentation.screens.main.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.composablecode.voyagerstudy.designSystem.components.Border
import com.composablecode.voyagerstudy.designSystem.components.InputSearch
import com.composablecode.voyagerstudy.designSystem.spacings
import com.composablecode.voyagerstudy.domain.entity.Trend
import com.composablecode.voyagerstudy.presentation.components.AppBar
import com.composablecode.voyagerstudy.presentation.components.TrendItem

@Composable
fun SearchScreen() {
    val spacing = MaterialTheme.spacings()
    val trends = listOf(
        Trend("Football", "Zinedine Zidane", "10.2 B"),
        Trend("Music", "Taylor Swift", "5.1 B"),
        Trend("Tech", "AI Advancements", "2.3 B"),
        Trend("Politics", "Elections 2024", "8.4 B"),
        Trend("Movies", "New Avatar Movie", "7.6 B")
    )
    Scaffold(
        topBar = {
            AppBar(
                contentPadding = PaddingValues(
                    start = spacing.md,
                    end = spacing.xxxl
                )
            ) {
                InputSearch(
                    label = "Search Twitter",

                    ) { it ->
                }
            }
        },
        modifier = Modifier.fillMaxSize(),
        content = {
            Border(
                modifier = Modifier.padding(spacing.lg)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().padding(spacing.lg),
                ) {
                    item {
                        Column {
                            Text("Trends for you", style = MaterialTheme.typography.h3)
                            Spacer(
                                modifier = Modifier.height(MaterialTheme.spacings().xxl)
                            )
                        }
                    }
                    itemsIndexed(trends) { index, trend ->
                        TrendItem(trend)

                        if (index < trends.size - 1) {
                            Spacer(
                                modifier = Modifier.height(spacing.lg)
                            )
                        }
                    }
                    item {

                        Text(
                            "Show more",
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.padding(top = spacing.xxl)
                        )
                    }
                }


            }

        }
    )
}


package com.example.meditation_ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.meditation_ui.entity.Feature
import com.example.meditation_ui.ui.components.ChipSection
import com.example.meditation_ui.ui.components.CurrentMeditation
import com.example.meditation_ui.ui.components.CustomTopAppBar
import com.example.meditation_ui.ui.theme.*


val features: List<Feature> = listOf(
    Feature(
        title = "Sleep meditation",
        R.drawable.ic_headphone,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3
    ),
    Feature(
        title = "Tips for sleeping",
        R.drawable.ic_videocam,
        LightGreen1,
        LightGreen2,
        LightGreen3
    ),
    Feature(
        title = "Night island",
        R.drawable.ic_headphone,
        OrangeYellow1,
        OrangeYellow2,
        OrangeYellow3
    ),
    Feature(
        title = "Calming sounds",
        R.drawable.ic_videocam,
        Beige1,
        Beige2,
        Beige3
    ), Feature(
        title = "Sleep meditation",
        R.drawable.ic_headphone,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3
    ),
    Feature(
        title = "Tips for sleeping",
        R.drawable.ic_videocam,
        LightGreen1,
        LightGreen2,
        LightGreen3
    ),
    Feature(
        title = "Night island",
        R.drawable.ic_headphone,
        OrangeYellow1,
        OrangeYellow2,
        OrangeYellow3
    ),
    Feature(
        title = "Calming sounds",
        R.drawable.ic_headphone,
        Beige1,
        Beige2,
        Beige3
    )


)

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Scaffold(
        backgroundColor = DeepBlue,
        topBar = { CustomTopAppBar() },
        content = { Body() },
    )


}


@Composable
fun Body() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                MaterialTheme.sizes.medium
            )
    ) {
        ChipSection(listOf("Android", "Flutter", "React native"))
        CurrentMeditation()
        FeatureSection(features = features)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(features: List<Feature>) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "Features",
            style = MaterialTheme.typography.h6.copy(color = TextWhite),
            modifier = Modifier.padding(
                top = MaterialTheme.sizes.extraMedium,
                bottom = MaterialTheme.sizes.medium
            )
        )
        LazyVerticalGrid(cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.sizes.medium),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.sizes.medium),
            content = {
                items(features) { feature ->
                    FeatureItem(feature)
                }
            })
    }

}

@Composable
fun FeatureItem(feature: Feature) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(MaterialTheme.sizes.small))
            .background(feature.darkColor)
            .padding(
                horizontal =
                MaterialTheme.sizes.medium,
                vertical = MaterialTheme.sizes.extraMedium,
            )
    ) {


        Text(
            feature.title,
            style = MaterialTheme.typography.h6,
            color = Color.White,
            lineHeight = 26.sp,
            modifier = Modifier.align(Alignment.TopStart)
        )
        Icon(
            painter = painterResource(id = feature.iconId),
            contentDescription = feature.title,
            tint = Color.White,
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Text(
            "Start",
            color = TextWhite,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable {
                    // Handle the click
                }
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(MaterialTheme.sizes.small))
                .background(ButtonBlue)
                .padding(
                    vertical = MaterialTheme.sizes.small,
                    horizontal = MaterialTheme.sizes.medium
                )
        )

    }
}
package com.example.meditation_ui.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.meditation_ui.R
import com.example.meditation_ui.entity.BottomMenuContent
import com.example.meditation_ui.entity.Feature
import com.example.meditation_ui.ui.components.ChipSection
import com.example.meditation_ui.ui.components.CurrentMeditation
import com.example.meditation_ui.ui.components.CustomTopAppBar
import com.example.meditation_ui.ui.components.FeatureSection
import com.example.meditation_ui.ui.theme.*


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
fun CustomBottomBar(
    items: List<BottomMenuContent>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomMenuContent) -> Unit
) {
    BottomNavigation(
        elevation = MaterialTheme.sizes.small,
        backgroundColor = DeepBlue
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        items.forEachIndexed { index, bottomMenuContent ->
            val selected = bottomMenuContent.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selectedContentColor = AquaBlue,
                unselectedContentColor = DarkerButtonBlue,
                onClick = {
                    onItemClick(bottomMenuContent)
                },
                selected = selected,
                icon = {
                    Icon(
                        painter = painterResource(id = bottomMenuContent.iconId),
                        contentDescription = bottomMenuContent.title,
                        tint = if (selected) TextWhite else DarkerButtonBlue,
                        modifier = Modifier.size(MaterialTheme.sizes.extraMedium)
                    )
                }

            )
        }
    }
}

@Composable
fun Body() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = MaterialTheme.sizes.medium,
                end = MaterialTheme.sizes.medium,
                top = MaterialTheme.sizes.medium
            )
    ) {
        ChipSection(listOf("Android", "Flutter", "React native"))
        CurrentMeditation()
        FeatureSection(features = features)
    }
}


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
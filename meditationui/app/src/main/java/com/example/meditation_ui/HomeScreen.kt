package com.example.meditation_ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.meditation_ui.ui.theme.DeepBlue
import com.example.meditation_ui.ui.theme.TextWhite
import com.example.meditation_ui.ui.theme.spacing

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
fun CustomTopAppBar(name: String = "Derek") {
    TopAppBar(

        backgroundColor = DeepBlue,
        elevation = MaterialTheme.spacing.default,
        title = {
            Column() {

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle()) {
                        append("Good morning, ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(name)
                    }
                }, style = MaterialTheme.typography.body1.copy(color = TextWhite))
                Text(
                    "We wish you have a good day!",
                    style = MaterialTheme.typography.body2.copy(color = TextWhite)
                )

            }
        }, actions = {

            Row(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = TextWhite,
                    modifier = Modifier
                        .size(MaterialTheme.spacing.extraMedium)

                )
            }


        })


}

@Composable
fun Body() {
    Column(modifier = Modifier.fillMaxSize()) {
        ChipSection()
    }
}


@Composable
fun ChipSection(chips: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(count = chips.size) {
            Box() {

            }
        }
    }
}
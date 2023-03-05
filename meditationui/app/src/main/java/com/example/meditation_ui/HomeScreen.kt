package com.example.meditation_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { CustomTopAppBar() },
        content = { Body() },
    )


}


@Composable
fun CustomTopAppBar(name: String = "Derek") {
    TopAppBar(title = { Column() {
        SpanStyle()
        Text(text = buildAnnotatedString { withStyle(style = SpanStyle()){
            append("Good morning, ")
        }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
            append(name)
        }  }, style = MaterialTheme.typography.body1)
        Text("We wish you have a good day!" , style = MaterialTheme.typography.body2)
    } })

}

@Composable
fun Body() {
    Column() {

    }
}
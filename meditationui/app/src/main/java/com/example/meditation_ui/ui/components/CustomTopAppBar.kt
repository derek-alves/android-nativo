package com.example.meditation_ui.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.meditation_ui.R
import com.example.meditation_ui.ui.theme.AquaBlue
import com.example.meditation_ui.ui.theme.DeepBlue
import com.example.meditation_ui.ui.theme.TextWhite
import com.example.meditation_ui.ui.theme.sizes

@Composable
fun CustomTopAppBar(name: String = "Derek") {
    TopAppBar(
        backgroundColor = DeepBlue,
        elevation = MaterialTheme.sizes.default,
        title = {
            Column() {

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle()) {
                        append("Good morning, ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(name)
                    }
                }, style = MaterialTheme.typography.h6.copy(color = TextWhite))
                Text(
                    "We wish you have a good day!",
                    style = MaterialTheme.typography.body2.copy(color = AquaBlue)
                )

            }
        }, actions = {

            Row(modifier = Modifier.padding(horizontal = MaterialTheme.sizes.small)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = TextWhite,
                    modifier = Modifier
                        .size(MaterialTheme.sizes.extraMedium)

                )
            }


        })


}
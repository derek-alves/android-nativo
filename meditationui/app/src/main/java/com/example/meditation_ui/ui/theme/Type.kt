package com.example.meditation_ui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.meditation_ui.R
val Gothical = FontFamily(
    Font(R.font.gothica1_bold, FontWeight.Bold),
    Font(R.font.gothica1_semibold , FontWeight.SemiBold),
    Font(R.font.gothica1_medium, FontWeight.Medium),
    Font(R.font.gothica1_regular, FontWeight.Normal),

    )
// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = Gothical
)
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */





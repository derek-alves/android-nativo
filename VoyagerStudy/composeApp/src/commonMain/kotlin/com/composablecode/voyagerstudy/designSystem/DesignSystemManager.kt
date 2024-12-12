package com.composablecode.voyagerstudy.designSystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.Font
import voyagerstudy.composeapp.generated.resources.Res
import voyagerstudy.composeapp.generated.resources.VT323_Regular


@Serializable
data class DesignTokens(
    val color: Map<String, TokenColor>,
    val font: Map<String, Map<String, TokenTypography>>,
    val spacing: Spacing
)

@Serializable
data class TokenColor(val value: String)

@Serializable
data class Spacing(
    val xxs: Int = 0,
    val xs: Int = 0,
    val sm: Int = 0,
    val md: Int = 0,
    val lg: Int = 0,
    val xl: Int = 0,
    val xxl: Int = 0,
    val xxxl: Int = 0,
    val xxxxl: Int = 0,
    val xxxxxl: Int = 0,
    val xxxxxxl: Int = 0
)

@Serializable
data class TokenTypography(
    val fontSize: Float,
    val textDecoration: String,
    val fontFamily: String,
    val fontWeight: Int,
    val fontStyle: String,
    val fontStretch: String,
    val letterSpacing: Float,
    val lineHeight: Float,
    val paragraphIndent: Float,
    val paragraphSpacing: Float,
    val textCase: String
)

class DesignSystemManager(tokensJson: String) {
    private var tokens: DesignTokens

    init {
        val json = Json {
            ignoreUnknownKeys = true
        }
        tokens = json.decodeFromString(tokensJson)

    }

    @Composable
    fun DesignSystemFont(): FontFamily {
        return FontFamily(
            Font(Res.font.VT323_Regular, weight = FontWeight.Normal)
        )
    }

    val spacings: Spacing = tokens.spacing
    val colors: Map<String, Color> by lazy {
        tokens.color.mapValues { entry ->
            val value = entry.value.value
            Color(
                value.substring(1, 3).toInt(16) / 255f,
                value.substring(3, 5).toInt(16) / 255f,
                value.substring(5, 7).toInt(16) / 255f,
                value.substring(7, 9).toInt(16) / 255f
            )
        }
    }

    val typography: Map<String, Map<String, TextStyle>> by lazy {
        tokens.font.mapValues { (fontName, sizes) ->
            sizes.mapValues { (size, style) ->
                TextStyle(

                    fontSize = style.fontSize.sp,
                    lineHeight = style.lineHeight.sp,
                    fontWeight = FontWeight(style.fontWeight),
                    letterSpacing = style.letterSpacing.sp
                )
            }
        }
    }
}

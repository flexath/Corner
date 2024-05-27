package com.flexath.corner.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.flexath.corner.R

val Charter = FontFamily(
    fonts = listOf(
        Font(R.font.charter_regular, FontWeight.Light),
        Font(R.font.charter_regular, FontWeight.Normal),
        Font(R.font.charter_regular, FontWeight.Medium),
        Font(R.font.charter_regular, FontWeight.SemiBold),
        Font(R.font.charter_bold, FontWeight.Bold),
    )
)

val Noe = FontFamily(
    fonts = listOf(
        Font(R.font.noe_regular, FontWeight.Light),
        Font(R.font.noe_regular, FontWeight.Normal),
        Font(R.font.noe_medium, FontWeight.Medium),
        Font(R.font.noe_medium, FontWeight.SemiBold),
        Font(R.font.noe_bold, FontWeight.Bold),
    )
)

enum class CustomFont {
    Charter,
    Noe
}

fun getFont(font: CustomFont): FontFamily {
    return when (font) {
        CustomFont.Charter -> {
            Charter
        }

        CustomFont.Noe -> {
            Noe
        }
    }
}

fun getTypography(font: CustomFont): Typography {
    return Typography(
        headlineLarge = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            lineHeight = 26.04.sp,
            letterSpacing = 0.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Medium,
            fontSize = 26.sp,
            lineHeight = 26.04.sp,
            letterSpacing = 0.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            lineHeight = 26.04.sp,
            letterSpacing = 0.sp
        ),
        titleLarge = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            lineHeight = 23.44.sp,
            letterSpacing = 0.sp
        ),
        titleMedium = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.38.sp
        ),
        titleSmall = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.38.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 18.23.sp,
            letterSpacing = 0.2.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 18.23.sp,
            letterSpacing = 0.2.sp
        ),
        bodySmall = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 15.62.sp,
            letterSpacing = 0.2.sp
        ),
        labelMedium = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            lineHeight = 15.62.sp,
            letterSpacing = 0.2.sp
        ),
        labelSmall = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            lineHeight = 13.02.sp,
            letterSpacing = 0.2.sp
        ),
    )
}
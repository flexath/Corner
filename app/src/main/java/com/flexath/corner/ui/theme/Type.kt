package com.flexath.corner.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargeText1
import com.flexath.corner.core.presentation.constants.Dimens.ExtraLargeText4
import com.flexath.corner.core.presentation.constants.Dimens.LargePadding5
import com.flexath.corner.core.presentation.constants.Dimens.LargeText1
import com.flexath.corner.core.presentation.constants.Dimens.LargeText10
import com.flexath.corner.core.presentation.constants.Dimens.LargeText2
import com.flexath.corner.core.presentation.constants.Dimens.LargeText3
import com.flexath.corner.core.presentation.constants.Dimens.LargeText5
import com.flexath.corner.core.presentation.constants.Dimens.LargeText6
import com.flexath.corner.core.presentation.constants.Dimens.LargeText8
import com.flexath.corner.core.presentation.constants.Dimens.MediumText1
import com.flexath.corner.core.presentation.constants.Dimens.MediumText2
import com.flexath.corner.core.presentation.constants.Dimens.MediumText3
import com.flexath.corner.core.presentation.constants.Dimens.MediumText4
import com.flexath.corner.core.presentation.constants.Dimens.MediumText5
import com.flexath.corner.core.presentation.constants.Dimens.SmallText5

val Charter = FontFamily(
    fonts = listOf(
        Font(R.font.charter_regular, FontWeight.Light),
        Font(R.font.charter_regular, FontWeight.Normal),
        Font(R.font.charter_regular, FontWeight.Medium),
        Font(R.font.charter_regular, FontWeight.SemiBold),
        Font(R.font.charter_bold, FontWeight.Bold),
        Font(R.font.charter_bold, FontWeight.ExtraBold),
    )
)

val Noe = FontFamily(
    fonts = listOf(
        Font(R.font.noe_regular, FontWeight.Light),
        Font(R.font.noe_regular, FontWeight.Normal),
        Font(R.font.noe_medium, FontWeight.Medium),
        Font(R.font.noe_medium, FontWeight.SemiBold),
        Font(R.font.noe_bold, FontWeight.Bold),
        Font(R.font.noe_bold, FontWeight.ExtraBold),
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
        displayLarge = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Bold,
            fontSize = ExtraLargeText4,
            lineHeight = 30.sp,
            letterSpacing = 0.sp
        ),
        displayMedium = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.SemiBold,
            fontSize = ExtraLargeText1,
            lineHeight = 30.sp,
            letterSpacing = 2.sp
        ),
        displaySmall = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Normal,
            fontSize = LargeText6,
            lineHeight = 26.04.sp,
            letterSpacing = 0.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Bold,
            fontSize = LargeText5,
            lineHeight = 26.04.sp,
            letterSpacing = 0.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Medium,
            fontSize = LargeText3,
            lineHeight = 26.04.sp,
            letterSpacing = 0.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Medium,
            fontSize = LargeText2,
            lineHeight = 26.04.sp,
            letterSpacing = 0.sp
        ),
        titleLarge = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Bold,
            fontSize = LargeText1,
            lineHeight = 23.44.sp,
            letterSpacing = 0.sp
        ),
        titleMedium = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Medium,
            fontSize = MediumText5,
            lineHeight = 24.sp,
            letterSpacing = 0.38.sp
        ),
        titleSmall = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Medium,
            fontSize = MediumText4,
            lineHeight = 20.sp,
            letterSpacing = 0.38.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Normal,
            fontSize = MediumText3,
            lineHeight = 18.23.sp,
            letterSpacing = 0.2.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Normal,
            fontSize = MediumText2,
            lineHeight = 18.23.sp,
            letterSpacing = 0.2.sp
        ),
        bodySmall = TextStyle(
            fontFamily = getFont(font),
            fontWeight = FontWeight.Normal,
            fontSize = MediumText1,
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
            fontSize = SmallText5,
            lineHeight = 13.02.sp,
            letterSpacing = 0.2.sp
        ),
    )
}
package com.flexath.corner.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.flexath.corner.core.presentation.activities.MainActivity
import com.flexath.corner.core.presentation.constants.largeCompatDimensions
import com.flexath.corner.core.presentation.constants.mediumCompatDimensions
import com.flexath.corner.core.presentation.constants.smallCompatDimensions

private val DarkColorScheme = darkColorScheme(
    primary = colorPrimaryDarkMode,
    onPrimary = colorOnPrimaryDarkMode,
    secondary = colorSecondaryDarkMode,
    background = colorBackgroundDarkMode,
)

private val LightColorScheme = lightColorScheme(
    primary = colorPrimaryLightMode,
    onPrimary = colorOnPrimaryLightMode,
    secondary = colorSecondaryLightMode,
    background = colorBackgroundLightMode

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun CornerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    activity: Activity = LocalContext.current as MainActivity,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val windowSize = calculateWindowSizeClass(activity = activity)
    val config = LocalConfiguration.current

    var appDimens = mediumCompatDimensions
    var typography = getTypography(CustomFont.Inter)

    when(windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            if (config.screenWidthDp <= 360) {
                appDimens = smallCompatDimensions
                typography = getSmallCompatTypography(CustomFont.Inter)
            } else if (config.screenWidthDp < 599) {
                appDimens = mediumCompatDimensions
                typography = getTypography(CustomFont.Inter)
            } else {
                appDimens = largeCompatDimensions
                typography = getLargeCompatTypography(CustomFont.Inter)
            }
        }

//        WindowWidthSizeClass.Medium -> {
//            appDimens = MediumDimens
//            typography = CompactTypography
//        }
//
//        WindowWidthSizeClass.Expanded -> {
//            appDimens = ExpandedDimens
//            typography = ExpandedTypography
//        }
//
//        else -> {
//            appDimens = ExpandedDimens
//            typography = ExpandedTypography
//        }
    }

    ProvideAppUtils(appDimens = appDimens) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}

val MaterialTheme.dimens
    @Composable
    get() = LocalAppDimens.current
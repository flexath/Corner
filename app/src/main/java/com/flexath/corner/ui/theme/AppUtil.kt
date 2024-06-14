package com.flexath.corner.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import com.flexath.corner.core.presentation.constants.Dimensions
import com.flexath.corner.core.presentation.constants.mediumCompatDimensions

@Composable
fun ProvideAppUtils(
    appDimens: Dimensions,
    content: @Composable () -> Unit,
) {
    val appDimensions = remember {
        appDimens
    }
    CompositionLocalProvider(LocalAppDimens provides appDimensions) {
        content()
    }
}

val LocalAppDimens = compositionLocalOf {
    mediumCompatDimensions
}

val ScreenOrientation
    @Composable
    get() = LocalConfiguration.current.orientation
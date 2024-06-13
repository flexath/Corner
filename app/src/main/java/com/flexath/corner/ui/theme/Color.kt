package com.flexath.corner.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.flexath.corner.core.presentation.utils.AppColors

//val colorPrimary = Color(0xFF007363)
//val colorOnPrimary = Color(0xFFF2F2F2)
//val colorSecondary = Color(0xFF1B8EF2)
//val colorBackground = Color(0xFFF2F2F2)
//
//val textColorPrimary = Color(0xFF262626)
//val textColorSecondary = Color(0xFFB4B4B5)
//val textColorSecondaryLight = Color(0xFFEFF0EF)
//
//val alertColor = Color(0xFFF23D3D)
//val strokeColor = Color(0xFFD2D4DD)
//val textFieldUnFocusedBackground = Color(0x1AB4B4B5)
//val textFieldStrokeColor = Color(0xFF58626A)
//val starColor = Color(0xFFFECF14)

// For Light Theme
val colorPrimaryLightMode = Color(0xFF3F51B5)
val colorOnPrimaryLightMode = Color(0xFFF2F2F2)
val colorSecondaryLightMode = Color(0xFFFFC107)
val colorBackgroundLightMode = Color(0xFFF8F9FA)

val textColorPrimaryLightMode = Color(0xFF212121)
val textColorSecondaryLightMode = Color(0xFF757575)
val textColorSecondaryLightLightMode = Color(0xFFFFFFFF)

val alertColorLightMode = Color(0xFFE53935)
val strokeColorLightMode = Color(0xFFE0E0E0)
val textFieldUnFocusedBackgroundLightMode = Color(0x1AE0E0E0)
val textFieldStrokeColorLightMode = Color(0xFFBDBDBD)
val starColorLightMode = Color(0xFFFECF14)

val shimmerStartColorLightMode = Color(0xFFF5F5F5)
val shimmerMiddleColorLightMode = Color(0xFFE0E0E0)
val shimmerEndColorLightMode = Color(0xFFECECEC)

// For Dark Theme
val colorPrimaryDarkMode = Color(0xFF293C95)
val colorOnPrimaryDarkMode = Color(0xFFFFFFFF)
val colorSecondaryDarkMode = Color(0xFFFF9800)
val colorBackgroundDarkMode = Color(0xFF212121)

val textColorPrimaryDarkMode = Color(0xFFFFFFFF)
val textColorSecondaryDarkMode = Color(0xFFCCCCCC)
val textColorSecondaryLightDarkMode = Color(0xFFFFFFFF)

val alertColorDarkMode = Color(0xFFE53935)
val strokeColorDarkMode = Color(0xFF424242)
val textFieldUnFocusedBackgroundDarkMode = Color(0xFF212121)
val textFieldStrokeColorDarkMode = Color(0xFF424242)
val starColorDarkMode = Color(0xFFFECF14)

val shimmerStartColorDarkMode = Color(0xFF303030)
val shimmerMiddleColorDarkMode = Color(0xFF212121 )
val shimmerEndColorDarkMode = Color(0xFF1A1A1A)

@Composable
fun getAppColor(color: AppColors): Color {
    return when(color) {
        AppColors.COLOR_PRIMARY -> if(!isSystemInDarkTheme()) colorPrimaryLightMode else colorPrimaryDarkMode
        AppColors.COLOR_ON_PRIMARY -> if(!isSystemInDarkTheme()) colorOnPrimaryLightMode else colorOnPrimaryDarkMode
        AppColors.COLOR_SECONDARY -> if(!isSystemInDarkTheme()) colorSecondaryLightMode else colorSecondaryDarkMode
        AppColors.COLOR_BACKGROUND -> if(!isSystemInDarkTheme()) colorBackgroundLightMode else colorBackgroundDarkMode
        AppColors.TEXT_COLOR_PRIMARY -> if(!isSystemInDarkTheme()) textColorPrimaryLightMode else textColorPrimaryDarkMode
        AppColors.TEXT_COLOR_SECONDARY -> if(!isSystemInDarkTheme()) textColorSecondaryLightMode else textColorSecondaryDarkMode
        AppColors.TEXT_COLOR_SECONDARY_LIGHT -> if(!isSystemInDarkTheme()) textColorSecondaryLightLightMode else textColorSecondaryLightDarkMode
        AppColors.ALERT_COLOR -> if(!isSystemInDarkTheme()) alertColorLightMode else alertColorDarkMode
        AppColors.STROKE_COLOR -> if(!isSystemInDarkTheme()) strokeColorLightMode else strokeColorDarkMode
        AppColors.TEXT_FIELD_UNFOCUSED_BACKGROUND -> if(!isSystemInDarkTheme()) textFieldUnFocusedBackgroundLightMode else textFieldUnFocusedBackgroundDarkMode
        AppColors.TEXT_FIELD_STROKE_COLOR -> if(!isSystemInDarkTheme()) textFieldStrokeColorLightMode else textFieldStrokeColorDarkMode
        AppColors.STAR_COLOR -> if(!isSystemInDarkTheme()) starColorLightMode else starColorDarkMode
        AppColors.SHIMMER_START_COLOR -> if(!isSystemInDarkTheme()) shimmerStartColorLightMode else shimmerStartColorDarkMode
        AppColors.SHIMMER_MIDDLE_COLOR -> if(!isSystemInDarkTheme()) shimmerMiddleColorLightMode else shimmerMiddleColorDarkMode
        AppColors.SHIMMER_END_COLOR -> if(!isSystemInDarkTheme()) shimmerEndColorLightMode else shimmerEndColorDarkMode
    }
}
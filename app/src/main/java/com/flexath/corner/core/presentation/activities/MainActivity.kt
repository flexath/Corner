package com.flexath.corner.core.presentation.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import com.flexath.corner.core.presentation.nav_graphs.NavGraph
import com.flexath.corner.core.presentation.nav_graphs.Route
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.ui.theme.CornerTheme
import com.flexath.corner.ui.theme.colorBackgroundDarkMode
import com.flexath.corner.ui.theme.colorBackgroundLightMode
import com.flexath.corner.ui.theme.getAppColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CornerTheme(
                dynamicColor = false
            ) {
                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemUiColor = rememberSystemUiController()

                SideEffect {
                    systemUiColor.setSystemBarsColor(
                        color = if (isSystemInDarkMode) {
                            colorBackgroundDarkMode
                        } else {
                            colorBackgroundLightMode
                        },
                        darkIcons = !isSystemInDarkMode
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = getAppColor(AppColors.COLOR_BACKGROUND)
                ) {
                    NavGraph(
                        modifier = Modifier.fillMaxSize(),
                        startGraph = Route.AuthSubGraph.route
                    )
                }
            }
        }
    }
}
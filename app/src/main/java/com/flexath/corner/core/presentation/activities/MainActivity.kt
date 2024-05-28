package com.flexath.corner.core.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import com.flexath.corner.core.presentation.nav_graphs.NavGraph
import com.flexath.corner.core.presentation.nav_graphs.Route
import com.flexath.corner.ui.theme.CornerTheme
import com.flexath.corner.ui.theme.colorBackground
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

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
                        color = colorBackground,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorBackground
                ) {
                    NavGraph(
                        applicationContext = applicationContext,
                        modifier = Modifier.fillMaxSize(),
                        startGraph = Route.AuthSubGraph.route
                    )
                }
            }
        }
    }
}
package com.flexath.corner.core.presentation.nav_graphs

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.flexath.corner.features.auth.presentation.nav_graphs.AuthSubGraph
import com.flexath.corner.features.main.presentation.nav_graphs.MainSubGraph

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    startGraph: String,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startGraph
    ) {
        navigation(
            startDestination = Route.AuthStartDestination.route,
            route = Route.AuthSubGraph.route
        ) {
            composable(
                route = Route.AuthStartDestination.route
            ) {
                AuthSubGraph(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        navigation(
            startDestination = Route.MainStartDestination.route,
            route = Route.MainSubGraph.route
        ) {
            composable(
                route = Route.MainStartDestination.route
            ) {
                MainSubGraph(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
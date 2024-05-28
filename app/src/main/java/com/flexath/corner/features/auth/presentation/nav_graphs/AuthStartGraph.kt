package com.flexath.corner.features.auth.presentation.nav_graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flexath.corner.core.presentation.nav_graphs.Route
import com.flexath.corner.features.auth.presentation.screens.RegisterScreen

@Composable
fun AuthSubGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.RegisterScreen.route
    ) {
        composable(
            route = Route.RegisterScreen.route
        ) {
            RegisterScreen(
                modifier = modifier
            )
        }

        composable(
            route = Route.LoginScreen.route
        ) {

        }
    }
}
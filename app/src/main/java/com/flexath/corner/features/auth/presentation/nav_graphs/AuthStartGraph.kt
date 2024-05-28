package com.flexath.corner.features.auth.presentation.nav_graphs

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flexath.corner.core.presentation.nav_graphs.Route
import com.flexath.corner.features.auth.presentation.google_sign_in.GoogleAuthUiClient
import com.flexath.corner.features.auth.presentation.screens.LoginScreen
import com.flexath.corner.features.auth.presentation.screens.RegisterScreen
import com.flexath.corner.features.auth.presentation.viewmodels.RegisterViewModel
import com.google.android.gms.auth.api.identity.Identity

@Composable
fun AuthSubGraph(
    applicationContext: Context,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.RegisterScreen.route
    ) {
        composable(
            route = Route.RegisterScreen.route
        ) {
            val googleAuthUiClient = GoogleAuthUiClient(
                Identity.getSignInClient(applicationContext)
            )

            val registerViewModel: RegisterViewModel = hiltViewModel()
            val registerState = registerViewModel.registerState.collectAsStateWithLifecycle()

            RegisterScreen(
                googleAuthUiClient = googleAuthUiClient,
                registerState = registerState.value,
                modifier = modifier,
                goToNextScreen = {
                    navController.navigate(Route.LoginScreen.route)
                }
            )
        }

        composable(
            route = Route.LoginScreen.route
        ) {
            LoginScreen()
        }
    }
}
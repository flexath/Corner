package com.flexath.corner.features.auth.presentation.nav_graphs

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flexath.corner.core.presentation.nav_graphs.Route
import com.flexath.corner.features.auth.presentation.events.RegisterEvent
import com.flexath.corner.features.auth.presentation.screens.LoginScreen
import com.flexath.corner.features.auth.presentation.screens.RegisterScreen
import com.flexath.corner.features.auth.presentation.viewmodels.RegisterViewModel
import kotlinx.coroutines.launch

@Composable
fun AuthSubGraph(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Route.RegisterScreen.route
    ) {
        composable(
            route = Route.RegisterScreen.route
        ) {
            val registerViewModel: RegisterViewModel = hiltViewModel()
            val registerState = registerViewModel.registerState.collectAsStateWithLifecycle()
            val userData = registerViewModel.getUserInformation()
            val coroutineScope = rememberCoroutineScope()

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult()
            ) {
                if (it.resultCode == Activity.RESULT_OK) {
                    registerViewModel.onEvent(
                        RegisterEvent.GoogleSignUpEvent(
                            it.data ?: return@rememberLauncherForActivityResult
                        )
                    )
                }
            }

            LaunchedEffect(key1 = Unit) {
                if(userData != null) {
                    navController.navigate(Route.LoginScreen.route)
                }
            }

            LaunchedEffect(key1 = registerState.value) {
                if (registerState.value.isSignInSuccessful) {
                    Toast.makeText(context, "Register Successfully", Toast.LENGTH_SHORT).show()
                    navController.navigate(Route.LoginScreen.route)
                    registerViewModel.resetRegisterState()
                }
            }

            RegisterScreen(
                modifier = modifier,
                onClickGoogleSignUpButton = {
                    coroutineScope.launch {
                        launcher.launch(
                            IntentSenderRequest.Builder(
                                registerViewModel.signIn() ?: return@launch
                            ).build()
                        )
                    }
                },
                onClickFacebookSignUpButton = {

                },
                onClickEmailSignUpButton = {

                }
            )
        }

        composable(
            route = Route.LoginScreen.route
        ) {
            val registerViewModel: RegisterViewModel = hiltViewModel()
            val userData = registerViewModel.getUserInformation()

            LoginScreen(
                userData = userData,
                modifier = Modifier.fillMaxSize(),
                onNavigateBack = {
                    registerViewModel.signOut()
                    Toast.makeText(context, "Sign Out!", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
            )
        }
    }
}
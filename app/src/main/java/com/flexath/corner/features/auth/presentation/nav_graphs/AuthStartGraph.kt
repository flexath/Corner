package com.flexath.corner.features.auth.presentation.nav_graphs

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.flexath.corner.core.presentation.nav_graphs.Route
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.features.auth.presentation.events.CreateAccountFormEvent
import com.flexath.corner.features.auth.presentation.events.SignOutEvent
import com.flexath.corner.features.auth.presentation.events.SignUpEvent
import com.flexath.corner.features.auth.presentation.events.ValidationEvent
import com.flexath.corner.features.auth.presentation.screens.ChooseInterestedCategoryScreen
import com.flexath.corner.features.auth.presentation.screens.CreateAccountScreen
import com.flexath.corner.features.auth.presentation.screens.LoginScreen
import com.flexath.corner.features.auth.presentation.screens.RecommendedForYouScreen
import com.flexath.corner.features.auth.presentation.screens.RegisterScreen
import com.flexath.corner.features.auth.presentation.screens.WelcomeScreen
import com.flexath.corner.features.auth.presentation.viewmodels.CreateAccountViewModel
import com.flexath.corner.features.auth.presentation.viewmodels.RegisterViewModel
import com.flexath.corner.ui.theme.getAppColor
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
            val userData = registerViewModel.getUserInformationFromGoogle()
            val userDataFromFacebook = registerViewModel.getUserInformationFromFacebook()
            val coroutineScope = rememberCoroutineScope()

            // Google SignIn
            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult()
            ) {
                if (it.resultCode == Activity.RESULT_OK) {
                    registerViewModel.resetRegisterState()
                    registerViewModel.onSignInEvent(
                        SignUpEvent.GoogleSignUpEvent(
                            it.data ?: return@rememberLauncherForActivityResult
                        )
                    )
                }
            }

            // Facebook SignIn
            val callbackManager = remember {
                CallbackManager.Factory.create()
            }

            val fbLauncher = rememberLauncherForActivityResult(
                LoginManager.getInstance().createLogInActivityResultContract(callbackManager)
            ) { result ->
                LoginManager.getInstance().onActivityResult(
                    result.resultCode,
                    result.data,
                    object: FacebookCallback<LoginResult> {
                        override fun onSuccess(result: LoginResult) {
                            println("onSuccess $result")
                            registerViewModel.resetRegisterState()
                            registerViewModel.onSignInEvent(SignUpEvent.FacebookSignUpEvent(result.accessToken))
                        }
                        override fun onCancel() {
                            println("onCancel")
                        }
                        override fun onError(error: FacebookException) {
                            println("onError $error")
                        }
                    }
                )
            }

            LaunchedEffect(key1 = Unit) {
                if(userData != null || userDataFromFacebook != null) {
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
                                registerViewModel.signInWithGoogle() ?: return@launch
                            ).build()
                        )
                    }
                },
                onClickFacebookSignUpButton = {
                    fbLauncher.launch(listOf("email","public_profile"))
                },
                onClickEmailSignUpButton = {
                    navController.navigate(Route.CreateAccountScreen.route)
                }
            )
        }

        composable(
            route = Route.LoginScreen.route
        ) {
            val registerViewModel: RegisterViewModel = hiltViewModel()
            val userData = registerViewModel.getUserInformationFromGoogle()
            val coroutineScope = rememberCoroutineScope()

            val userDataFromFacebook = registerViewModel.getUserInformationFromFacebook()

            Log.i("FacebookUserData","Data: $userDataFromFacebook")

            LoginScreen(
                userData = userData,
                modifier = Modifier.fillMaxSize(),
                onNavigateBack = {
                    coroutineScope.launch {
                        registerViewModel.onSignOutEvent(event = SignOutEvent.GoogleSignOutEvent)
                        navController.navigateUp()
                    }
                    Toast.makeText(context, "Sign Out!", Toast.LENGTH_SHORT).show()
                }
            )
        }

        composable(
            route = Route.CreateAccountScreen.route
        ) {
            val viewModel: CreateAccountViewModel = hiltViewModel()
            val createAccountFormState = viewModel.createAccountState.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = context) {
                viewModel.validationEvent.collect {
                    when (it) {
                        ValidationEvent.Success -> {
                            Toast.makeText(context,"Created account successfully!",Toast.LENGTH_SHORT).show()
                            navController.navigate(Route.WelcomeScreen.route)
                        }
                        ValidationEvent.Failed -> {
                            Toast.makeText(context,"Account creation failed!",Toast.LENGTH_SHORT).show()
                            Log.i("CreateFormState","Error: ${createAccountFormState.value.fullNameError}")
                            Log.i("CreateFormState","Error: ${createAccountFormState.value.emailError}")
                        }
                    }
                }
            }

            CreateAccountScreen(
                modifier = Modifier.fillMaxSize(),
                createAccountFormState = createAccountFormState.value,
                onNavigateBack = {
                    navController.navigateUp()
                },
                onClickCreateAccountButton = {
                    viewModel.onCreateAccountEvent(CreateAccountFormEvent.Submit)
                },
                onFullNameChanged = {
                    viewModel.onCreateAccountEvent(CreateAccountFormEvent.UserNameChanged(it))
                },
                onEmailChanged = {
                    viewModel.onCreateAccountEvent(CreateAccountFormEvent.EmailChanged(it))
                }
            )
        }

        composable(
            route = Route.WelcomeScreen.route
        ) {
            WelcomeScreen(
                modifier = Modifier.fillMaxSize(),
                onClickContinueButton = {
                    navController.navigate(Route.ChooseInterestedCategoryScreen.route)
                }
            )
        }

        composable(
            route = Route.ChooseInterestedCategoryScreen.route
        ) {
            ChooseInterestedCategoryScreen(
                modifier = Modifier.fillMaxSize().background(getAppColor(AppColors.COLOR_BACKGROUND)),
                onNavigateBack = {
                    navController.navigateUp()
                },
                onClickContinueButton = {
                    navController.navigate(Route.RecommendedForYouScreen.route)
                }
            )
        }

        composable(
            route = Route.RecommendedForYouScreen.route
        ) {
            RecommendedForYouScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateBack = {
                    navController.navigateUp()
                },
                onClickFinishButton = {

                }
            )
        }
    }
}
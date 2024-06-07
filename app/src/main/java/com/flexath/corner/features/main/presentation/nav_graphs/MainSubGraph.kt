package com.flexath.corner.features.main.presentation.nav_graphs

import android.widget.Toast
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.flexath.corner.R
import com.flexath.corner.core.presentation.nav_graphs.Route
import com.flexath.corner.features.main.presentation.events.MainWidgetEvent
import com.flexath.corner.features.main.presentation.screens.BookmarkScreen
import com.flexath.corner.features.main.presentation.screens.HomeScreen
import com.flexath.corner.features.main.presentation.screens.ProfileScreen
import com.flexath.corner.features.main.presentation.screens.SearchScreen
import com.flexath.corner.features.main.presentation.screens.common.MainBottomBar
import com.flexath.corner.features.main.presentation.viewmodels.MainWidgetViewModel
import com.flexath.corner.ui.theme.colorBackground
import com.flexath.corner.ui.theme.colorPrimary

@Composable
fun MainSubGraph(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()
    val backStackEntry = navHostController.currentBackStackEntryAsState().value
    val context = LocalContext.current

    val bottomBarVisibility by remember(key1 = backStackEntry) {
        derivedStateOf {
            backStackEntry?.destination?.route == Route.HomeScreen.route ||
                    backStackEntry?.destination?.route == Route.SearchScreen.route ||
                    backStackEntry?.destination?.route == Route.BookmarkScreen.route ||
                    backStackEntry?.destination?.route == Route.ProfileScreen.route
        }
    }

    Scaffold(
        floatingActionButton = {
            if (backStackEntry?.destination?.route != Route.BookmarkScreen.route) {
                FloatingActionButton(
                    onClick = {
                        Toast.makeText(context,"It is clicked",Toast.LENGTH_SHORT).show()
                    },
                    containerColor = colorPrimary,
                    contentColor = colorBackground,
                    modifier = Modifier.clip(CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pencil),
                        contentDescription = "Pencil"
                    )
                }
            }
        },
        bottomBar = {
            if (bottomBarVisibility) {
                MainBottomBar(navHostController = navHostController)
            }
        },
        modifier = modifier
    ) {
        val bottomPadding = it.calculateBottomPadding()
        val topPadding = it.calculateTopPadding()

        NavHost(
            navController = navHostController,
            startDestination = Route.HomeScreen.route,
            enterTransition = {
                EnterTransition.None
            },
            exitTransition = {
                ExitTransition.None
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = bottomPadding, top = topPadding)
        ) {
            composable(
                route = Route.HomeScreen.route
            ) {
                val mainWidgetViewModel: MainWidgetViewModel = hiltViewModel()
                val dialogIsShownState = mainWidgetViewModel.isBecomeAFriendDialogShown.collectAsStateWithLifecycle()

                HomeScreen(
                    modifier = Modifier.fillMaxSize(),
                    dialogIsShown = dialogIsShownState.value,
                    onDismissDialog = {
                        mainWidgetViewModel.onWidgetEvent(MainWidgetEvent.BecomeAFriendDialog(false))
                    },
                    onClickLearnMoreDialog = {

                    }
                )
            }

            composable(
                route = Route.SearchScreen.route
            ) {
                SearchScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(
                route = Route.BookmarkScreen.route
            ) {
                BookmarkScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(
                route = Route.ProfileScreen.route
            ) {
                ProfileScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainSubGraphPreview() {
    MainSubGraph(
        modifier = Modifier.fillMaxSize()
    )
}
package com.flexath.corner.features.main.presentation.screens.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.flexath.corner.R
import com.flexath.corner.core.presentation.constants.Dimens.SmallPadding4
import com.flexath.corner.core.presentation.nav_graphs.Route
import com.flexath.corner.core.presentation.utils.AppColors
import com.flexath.corner.ui.theme.getAppColor

@Composable
fun MainBottomBar(
    navHostController: NavHostController
) {
    val backStackEntry = navHostController.currentBackStackEntryAsState().value

    var selectedBottomItemIndex by remember {
        mutableIntStateOf(0)
    }

    selectedBottomItemIndex = when (backStackEntry?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.SearchScreen.route -> 1
        Route.BookmarkScreen.route -> 2
        else -> 3
    }

    BottomAppBar(
        containerColor = getAppColor(AppColors.COLOR_BACKGROUND),
        modifier = Modifier
            .fillMaxWidth()

            .shadow(
                elevation = SmallPadding4,
                spotColor = getAppColor(AppColors.STROKE_COLOR)
            ).height(60.dp)

    ) {
        bottomBarItemList.forEachIndexed { index, bottomBarItem ->
            NavigationBarItem(
                selected = selectedBottomItemIndex == index,
                onClick = {
                    selectedBottomItemIndex = index
                    navHostController.navigate(bottomBarItem.route) {
                        navHostController.graph.startDestinationRoute?.let { startDestinationRoute ->
                            popUpTo(startDestinationRoute) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = {
//                        Text(
//                            text = bottomBarItem.label,
//                            style = MaterialTheme.typography.labelMedium.copy(
//                                fontWeight = if(selectedBottomItemIndex == index) {
//                                    FontWeight.Bold
//                                } else {
//                                    FontWeight.Medium
//                                }
//                            ),
//                            color = if(selectedBottomItemIndex == index) {
//                                colorPrimary
//                            } else {
//                                textColorPrimary
//                            }
//                        )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = bottomBarItem.icon),
                        contentDescription = bottomBarItem.label
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = getAppColor(AppColors.COLOR_PRIMARY),
                    unselectedIconColor = getAppColor(AppColors.TEXT_FIELD_STROKE_COLOR)
                )
            )
        }
    }
}

data class BottomBarItem(
    val label: String,
    val route: String,
    @DrawableRes val icon: Int
)

val bottomBarItemList = listOf(
    BottomBarItem(
        label = "Home",
        route = Route.HomeScreen.route,
        icon = R.drawable.ic_home
    ),
    BottomBarItem(
        label = "Search",
        route = Route.SearchScreen.route,
        icon = R.drawable.ic_search
    ),
    BottomBarItem(
        label = "Bookmark",
        route = Route.BookmarkScreen.route,
        icon = R.drawable.ic_bookmark
    ),
    BottomBarItem(
        label = "Profile",
        route = Route.ProfileScreen.route,
        icon = R.drawable.ic_profile
    ),
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainBottomBarPreview() {
    MainBottomBar(navHostController = rememberNavController())
}
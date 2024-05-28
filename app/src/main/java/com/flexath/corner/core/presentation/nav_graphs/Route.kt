package com.flexath.corner.core.presentation.nav_graphs

import com.flexath.corner.core.presentation.nav_graphs.NavGraphConstants.AUTH_SUB_GRAPH
import com.flexath.corner.core.presentation.nav_graphs.NavGraphConstants.HOME_SCREEN
import com.flexath.corner.core.presentation.nav_graphs.NavGraphConstants.LOGIN_SCREEN
import com.flexath.corner.core.presentation.nav_graphs.NavGraphConstants.MAIN_SUB_GRAPH
import com.flexath.corner.core.presentation.nav_graphs.NavGraphConstants.PROFILE_SCREEN
import com.flexath.corner.core.presentation.nav_graphs.NavGraphConstants.REGISTER_SCREEN
import com.flexath.corner.core.presentation.nav_graphs.NavGraphConstants.SEARCH_SCREEN

sealed class Route(val route: String) {

    // Graph Start Destination
    data object AuthStartDestination : Route(NavGraphConstants.AUTH_START_DESTINATION)
    data object MainStartDestination : Route(NavGraphConstants.MAIN_START_DESTINATION)

    // Main
    data object HomeScreen : Route(HOME_SCREEN)
    data object ProfileScreen : Route(PROFILE_SCREEN)
    data object SearchScreen : Route(SEARCH_SCREEN)

    // Auth
    data object LoginScreen : Route(LOGIN_SCREEN)
    data object RegisterScreen : Route(REGISTER_SCREEN)

    // sub-graphs
    data object AuthSubGraph : Route(AUTH_SUB_GRAPH)
    data object MainSubGraph : Route(MAIN_SUB_GRAPH)
}
package klyuch.echovote.core.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import klyuch.echovote.core.ui.navigation.Routes
import klyuch.echovote.core.ui.theme.localNavigationState
import klyuch.echovote.core.ui.theme.resources.Animations

@Composable
fun AppNavGraph(
    homeScreen: @Composable () -> Unit,
    postVoteScreen: @Composable () -> Unit,
    profileScreen: @Composable () -> Unit
) {
    NavHost(
        navController = localNavigationState.current.navController,
        startDestination = Routes.HomeBlock,
        enterTransition = Animations.enterTransition,
        exitTransition = Animations.exitTransition,
        popEnterTransition = Animations.enterTransition,
        popExitTransition = Animations.exitTransition
    ) {
        homeNavGraph(
            homeScreen = homeScreen
        )
        postVoteNavGraph(
            postVoteScreen = postVoteScreen
        )
        profileNavGraph(
            profileScreen = profileScreen
        )
    }
}
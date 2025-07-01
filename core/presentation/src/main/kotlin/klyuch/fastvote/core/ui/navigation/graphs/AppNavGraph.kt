package klyuch.fastvote.core.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import klyuch.fastvote.core.ui.navigation.Routes
import klyuch.fastvote.core.ui.theme.localNavigationState
import klyuch.fastvote.core.ui.theme.resources.Animations

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
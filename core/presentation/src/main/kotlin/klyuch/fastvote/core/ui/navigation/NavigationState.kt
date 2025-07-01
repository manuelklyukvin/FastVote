package klyuch.fastvote.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(val navController: NavHostController) {
    fun navigateToBlock(block: Routes) = navController.navigate(block) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    fun navigateToRoute(route: Routes) = navController.navigate(route) {
        launchSingleTop = true
        restoreState = true
    }

    fun navigateUp() = navController.popBackStack()
}

@Composable
fun rememberNavigationState(): NavigationState {
    val navController = rememberNavController()
    navController.enableOnBackPressed(true)
    return remember(navController) { NavigationState(navController) }
}
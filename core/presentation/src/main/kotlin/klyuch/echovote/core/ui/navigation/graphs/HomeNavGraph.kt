package klyuch.echovote.core.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import klyuch.echovote.core.ui.navigation.Routes

fun NavGraphBuilder.homeNavGraph(homeScreen: @Composable () -> Unit) {
    navigation<Routes.HomeBlock>(startDestination = Routes.Home) {
        composable<Routes.Home> { homeScreen() }
    }
}
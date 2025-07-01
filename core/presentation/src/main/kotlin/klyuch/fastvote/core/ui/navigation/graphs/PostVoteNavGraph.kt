package klyuch.fastvote.core.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import klyuch.fastvote.core.ui.navigation.Routes

fun NavGraphBuilder.postVoteNavGraph(
    postVoteScreen: @Composable () -> Unit
) {
    navigation<Routes.PostVoteBlock>(startDestination = Routes.PostVote) {
        composable<Routes.PostVote> { postVoteScreen() }
    }
}
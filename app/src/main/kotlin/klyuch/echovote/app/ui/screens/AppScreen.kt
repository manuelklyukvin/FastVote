package klyuch.echovote.app.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import klyuch.echovote.core.ui.components.scaffolds.AppScaffold
import klyuch.echovote.core.ui.navigation.graphs.AppNavGraph
import klyuch.echovote.core.ui.theme.AppTheme
import klyuch.echovote.home.ui.screens.HomeScreen

@Preview
@Composable
fun AppScreen() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            AppScaffold {
                AppNavGraph(
                    homeScreen = { HomeScreen() },
                    postVoteScreen = { },
                    profileScreen = { },
                )
            }
        }
    }
}
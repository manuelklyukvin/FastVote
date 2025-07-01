package klyuch.fastvote.app.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import klyuch.fastvote.core.ui.components.scaffolds.AppScaffold
import klyuch.fastvote.core.ui.navigation.graphs.AppNavGraph
import klyuch.fastvote.core.ui.theme.AppTheme
import klyuch.fastvote.home.ui.screens.HomeScreen
import org.koin.androidx.compose.koinViewModel

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
                    homeScreen = { HomeScreen(koinViewModel()) },
                    postVoteScreen = { },
                    profileScreen = { },
                )
            }
        }
    }
}
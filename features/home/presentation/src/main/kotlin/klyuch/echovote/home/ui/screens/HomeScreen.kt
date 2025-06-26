package klyuch.echovote.home.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import klyuch.echovote.core.ui.theme.AppTheme
import klyuch.echovote.core.ui.view_models.models.AppViewState
import klyuch.echovote.home.ui.view_models.HomeViewModel
import klyuch.echovote.home.ui.view_models.models.HomeIntent
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()
    val onIntent = viewModel::onIntent

    LaunchedEffect(Unit) {
        onIntent(HomeIntent.OnScreenOpened)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colorScheme.background)
    ) {
        when (state.viewState) {
            AppViewState.LOADING -> LoadingHomeScreen()
            AppViewState.CONTENT -> ContentHomeScreen(state, onIntent)
            AppViewState.ERROR -> Unit
        }
    }
}
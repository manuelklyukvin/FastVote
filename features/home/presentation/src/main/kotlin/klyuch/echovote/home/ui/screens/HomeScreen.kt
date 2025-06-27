package klyuch.echovote.home.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import klyuch.echovote.core.ui.components.images.AppIcon
import klyuch.echovote.core.ui.components.text_fields.AppTextField
import klyuch.echovote.core.ui.theme.AppTheme
import klyuch.echovote.core.ui.utils.noIndicationClickable
import klyuch.echovote.core.ui.view_models.models.AppViewState
import klyuch.echovote.home.R
import klyuch.echovote.home.ui.view_models.HomeViewModel
import klyuch.echovote.home.ui.view_models.models.HomeIntent
import klyuch.echovote.home.ui.view_models.models.HomeState
import org.koin.androidx.compose.koinViewModel
import klyuch.echovote.core.R as CoreR

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
        SearchBar(state, onIntent)
        when (state.viewState) {
            AppViewState.LOADING -> LoadingHomeScreen()
            AppViewState.CONTENT -> ContentHomeScreen(state, onIntent)
            AppViewState.ERROR -> Unit
        }
    }
}

@Composable
private fun SearchBar(state: HomeState, onIntent: (HomeIntent) -> Unit) {
    AppTextField(
        modifier = Modifier.padding(
            horizontal = AppTheme.shapes.screenPadding,
            vertical = AppTheme.shapes.paddingSmall
        ),
        state = state.searchState,
        hint = stringResource(R.string.search_hint),
        trailingIcon = {
            AppIcon(
                modifier = Modifier
                    .size(AppTheme.shapes.sizeSmall)
                    .noIndicationClickable { onIntent(HomeIntent.OnSearchButtonClicked) },
                model = painterResource(CoreR.drawable.search)
            )
        }
    )
}
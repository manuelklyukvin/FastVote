package klyuch.echovote.home.ui.view_models

import klyuch.echovote.core.ui.view_models.AppViewModel
import klyuch.echovote.core.ui.view_models.models.AppViewState
import klyuch.echovote.home.ui.view_models.models.HomeIntent
import klyuch.echovote.home.ui.view_models.models.HomeState

class HomeViewModel : AppViewModel<HomeState, HomeIntent>(HomeState()) {
    override fun onIntent(intent: HomeIntent) = when (intent) {
        HomeIntent.OnScreenOpened -> onScreenOpened()
        HomeIntent.OnSearchButtonClicked -> onSearchButtonClicked()
        is HomeIntent.OnUserClicked -> onUserClicked(intent.userId)
        HomeIntent.OnMoreButtonClicked -> onMoreButtonClicked()
        is HomeIntent.OnTagClicked -> onTagClicked(intent.tag)
    }

    private fun onScreenOpened() = withLoadingState {
        update { copy(viewState = AppViewState.CONTENT) }
    }

    private fun onSearchButtonClicked() = withContentState {  }

    private fun onUserClicked(userId: Long) = withContentState {  }

    private fun onMoreButtonClicked() = withContentState {  }

    private fun onTagClicked(tag: String) = withContentState {  }
}
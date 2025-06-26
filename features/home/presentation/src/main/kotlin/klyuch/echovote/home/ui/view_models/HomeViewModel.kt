package klyuch.echovote.home.ui.view_models

import klyuch.echovote.core.ui.view_models.AppViewModel
import klyuch.echovote.home.ui.view_models.models.HomeIntent
import klyuch.echovote.home.ui.view_models.models.HomeState

class HomeViewModel : AppViewModel<HomeState, HomeIntent>(HomeState()) {
    override fun onIntent(intent: HomeIntent) = when (intent) {
        HomeIntent.OnScreenOpened -> onScreenOpened()
    }

    private fun onScreenOpened() = withLoadingState {  }
}
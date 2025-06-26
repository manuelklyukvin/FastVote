package klyuch.echovote.home.ui.view_models.models

import klyuch.echovote.core.ui.view_models.models.AppState
import klyuch.echovote.core.ui.view_models.models.AppViewState

data class HomeState(
    override val viewState: AppViewState = AppViewState.LOADING
) : AppState()
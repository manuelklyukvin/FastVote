package klyuch.echovote.home.ui.view_models.models

import androidx.annotation.StringRes
import androidx.compose.foundation.text.input.TextFieldState
import klyuch.echovote.core.ui.view_models.models.AppState
import klyuch.echovote.core.ui.view_models.models.AppViewState
import klyuch.echovote.votes.models.PresentationVote

data class HomeState(
    override val viewState: AppViewState = AppViewState.LOADING,
    val searchState: TextFieldState = TextFieldState(),
    val votes: List<PresentationVote> = emptyList(),
    @StringRes val errorResId: Int? = null
) : AppState()
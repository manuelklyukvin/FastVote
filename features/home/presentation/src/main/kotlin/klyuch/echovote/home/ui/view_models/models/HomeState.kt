package klyuch.echovote.home.ui.view_models.models

import androidx.compose.foundation.text.input.TextFieldState
import klyuch.echovote.core.ui.view_models.models.AppState
import klyuch.echovote.core.ui.view_models.models.AppViewState
import klyuch.echovote.home.models.PresentationVote

data class HomeState(
    override val viewState: AppViewState = AppViewState.LOADING,
    val searchState: TextFieldState = TextFieldState(),
    val votes: List<PresentationVote> = listOf(
        PresentationVote(),
        PresentationVote(imageUrl = ""),
        PresentationVote(imageUrl = ""),
        PresentationVote(
            tags = listOf("семья", "дети", "крепкийбрак", "дом", "любовь", "патриархат", "MANMANMAN", "хочувреки", "попес")
        ),
        PresentationVote(imageUrl = ""),
    )
) : AppState()
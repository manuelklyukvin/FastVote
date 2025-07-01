package klyuch.fastvote.home.ui.view_models.models

import klyuch.fastvote.core.ui.view_models.models.AppIntent
import klyuch.fastvote.votes.models.PresentationAnswer

sealed interface HomeIntent : AppIntent {
    data object OnScreenOpened : HomeIntent
    data object OnSearchButtonClicked : HomeIntent
    data class OnUserClicked(val userId: Long) : HomeIntent
    data class OnTagClicked(val tag: String) : HomeIntent
    data class OnAnswerClicked(val answer: PresentationAnswer) : HomeIntent
    data object OnRetryButtonClicked : HomeIntent
}
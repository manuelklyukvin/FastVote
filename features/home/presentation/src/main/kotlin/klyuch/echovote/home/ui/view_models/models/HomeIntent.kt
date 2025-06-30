package klyuch.echovote.home.ui.view_models.models

import klyuch.echovote.core.ui.view_models.models.AppIntent
import klyuch.echovote.votes.models.PresentationAnswer

sealed class HomeIntent : AppIntent() {
    data object OnScreenOpened : HomeIntent()
    data object OnSearchButtonClicked : HomeIntent()
    data class OnUserClicked(val userId: Long) : HomeIntent()
    data object OnMoreButtonClicked : HomeIntent()
    data class OnTagClicked(val tag: String) : HomeIntent()
    data class OnAnswerClicked(val answer: PresentationAnswer) : HomeIntent()
    data object OnRetryButtonClicked : HomeIntent()
}
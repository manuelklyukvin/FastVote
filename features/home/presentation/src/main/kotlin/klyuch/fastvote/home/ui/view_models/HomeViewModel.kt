package klyuch.fastvote.home.ui.view_models

import androidx.lifecycle.viewModelScope
import klyuch.fastvote.core.ui.view_models.AppViewModel
import klyuch.fastvote.core.ui.view_models.models.AppViewState
import klyuch.fastvote.core.utils.operations.mappers.OperationErrorMapper
import klyuch.fastvote.core.utils.operations.models.OperationResult
import klyuch.fastvote.home.ui.view_models.models.HomeIntent
import klyuch.fastvote.home.ui.view_models.models.HomeState
import klyuch.fastvote.votes.models.PresentationAnswer
import klyuch.fastvote.votes.models.toPresentation
import klyuch.fastvote.votes.use_cases.GetVotesUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getVotesUseCase: GetVotesUseCase,
    private val operationErrorMapper: OperationErrorMapper
) : AppViewModel<HomeState, HomeIntent>(HomeState()) {
    private var getVotesJob: Job? = null

    override fun onIntent(intent: HomeIntent) = when (intent) {
        HomeIntent.OnScreenOpened -> onScreenOpened()
        HomeIntent.OnSearchButtonClicked -> onSearchButtonClicked()
        is HomeIntent.OnUserClicked -> onUserClicked(intent.userId)
        is HomeIntent.OnTagClicked -> onTagClicked(intent.tag)
        is HomeIntent.OnAnswerClicked -> onAnswerClicked(intent.answer)
        HomeIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun onScreenOpened() = withLoadingState {
        getVotesJob?.cancel()

        getVotesJob = viewModelScope.launch {
            getVotesUseCase(null).collect { result ->
                when (result) {
                    is OperationResult.Success -> update {
                        copy(
                            viewState = AppViewState.CONTENT,
                            votes = result.data.map { vote -> vote.toPresentation() },
                            errorResId = null
                        )
                    }
                    is OperationResult.Error -> update {
                        copy(
                            viewState = AppViewState.ERROR,
                            errorResId = operationErrorMapper.mapToResId(result.error)
                        )
                    }
                }
            }
        }
    }

    private fun onSearchButtonClicked() = withContentState { }

    private fun onUserClicked(userId: Long) = withContentState { }

    private fun onTagClicked(tag: String) = withContentState { }

    private fun onAnswerClicked(answer: PresentationAnswer) = withContentState {
        val updatedVotes = state.value.votes.map { vote ->
            if (vote.answers.any { it.id == answer.id }) {
                val updatedAnswers = vote.answers.map {
                    if (it.id == answer.id) {
                        it.copy(votesCount = it.votesCount + 1)
                    } else it
                }
                vote.copy(
                    selectedAnswerId = answer.id,
                    answers = updatedAnswers
                )
            } else vote
        }

        update { copy(votes = updatedVotes) }
    }

    private fun onRetryButtonClicked() = withErrorState {
        update { copy(viewState = AppViewState.LOADING) }
        onScreenOpened()
    }

    override fun onCleared() {
        super.onCleared()
        getVotesJob?.cancel()
    }
}
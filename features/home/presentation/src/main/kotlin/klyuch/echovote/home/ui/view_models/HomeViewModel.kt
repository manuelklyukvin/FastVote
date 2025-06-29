package klyuch.echovote.home.ui.view_models

import androidx.lifecycle.viewModelScope
import klyuch.echovote.core.ui.view_models.AppViewModel
import klyuch.echovote.core.ui.view_models.models.AppViewState
import klyuch.echovote.core.utils.operations.mappers.OperationErrorMapper
import klyuch.echovote.core.utils.operations.models.OperationResult
import klyuch.echovote.home.ui.view_models.models.HomeIntent
import klyuch.echovote.home.ui.view_models.models.HomeState
import klyuch.echovote.votes.models.toPresentation
import klyuch.echovote.votes.use_cases.GetVotesUseCase
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
        HomeIntent.OnMoreButtonClicked -> onMoreButtonClicked()
        is HomeIntent.OnTagClicked -> onTagClicked(intent.tag)
        HomeIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun onScreenOpened() = withLoadingState {
        getVotesJob?.cancel()

        getVotesJob = viewModelScope.launch {
            getVotesUseCase().collect { result ->
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

    private fun onSearchButtonClicked() = withContentState {  }

    private fun onUserClicked(userId: Long) = withContentState {  }

    private fun onMoreButtonClicked() = withContentState {  }

    private fun onTagClicked(tag: String) = withContentState {  }

    private fun onRetryButtonClicked() = withErrorState {
        update { copy(viewState = AppViewState.LOADING) }
        onScreenOpened()
    }

    override fun onCleared() {
        super.onCleared()
        getVotesJob?.cancel()
    }
}
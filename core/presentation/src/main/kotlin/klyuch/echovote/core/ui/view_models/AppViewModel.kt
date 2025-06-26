package klyuch.echovote.core.ui.view_models

import androidx.lifecycle.ViewModel
import klyuch.echovote.core.ui.view_models.models.AppIntent
import klyuch.echovote.core.ui.view_models.models.AppState
import klyuch.echovote.core.ui.view_models.models.AppViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class AppViewModel<S : AppState, I : AppIntent>(initialState: S) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state get() = _state.asStateFlow()

    protected fun reduce(reducer: S.() -> S) = _state.update { it.reducer() }

    abstract fun onIntent(intent: I)

    protected inline fun withLoadingState(block: () -> Unit) {
        if (state.value.viewState == AppViewState.LOADING) block()
    }
    protected inline fun withContentState(block: () -> Unit) {
        if (state.value.viewState == AppViewState.CONTENT) block()
    }
    protected inline fun withErrorState(block: () -> Unit) {
        if (state.value.viewState == AppViewState.ERROR) block()
    }
}
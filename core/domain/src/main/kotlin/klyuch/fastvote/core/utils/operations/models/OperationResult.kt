package klyuch.fastvote.core.utils.operations.models

sealed interface OperationResult<out D, out E> {
    data class Success<out D>(val data: D) : OperationResult<D, Nothing>
    data class Error<out E>(val error: E) : OperationResult<Nothing, E>
}
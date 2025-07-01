package klyuch.fastvote.core.utils.operations.models

sealed interface OperationError {
    data object Network : OperationError
    data object ServerUnavailable : OperationError
    data object BadRequest : OperationError
    data object NotFound : OperationError
    data object Internal : OperationError
    data object Unknown : OperationError
}
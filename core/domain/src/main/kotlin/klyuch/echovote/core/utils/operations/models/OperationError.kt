package klyuch.echovote.core.utils.operations.models

sealed class OperationError {
    data object Network : OperationError()
    data object ServerUnavailable : OperationError()
    data object BadRequest : OperationError()
    data object NotFound : OperationError()
    data object Internal : OperationError()
    data object Unknown : OperationError()
}
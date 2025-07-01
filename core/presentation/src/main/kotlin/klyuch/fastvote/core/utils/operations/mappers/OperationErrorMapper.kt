package klyuch.fastvote.core.utils.operations.mappers

import klyuch.fastvote.core.R
import klyuch.fastvote.core.utils.operations.models.OperationError

class OperationErrorMapper {
    fun mapToResId(error: OperationError) = when (error) {
        OperationError.Network -> R.string.operation_error_network
        OperationError.ServerUnavailable -> R.string.operation_error_server_unavailable
        OperationError.BadRequest -> R.string.operation_error_bad_request
        OperationError.NotFound -> R.string.operation_error_not_found
        OperationError.Internal -> R.string.operation_error_internal
        OperationError.Unknown -> R.string.operation_error_unknown
    }
}
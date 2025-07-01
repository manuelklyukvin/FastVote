package klyuch.fastvote.core.utils.operations.providers

import klyuch.fastvote.core.utils.operations.models.OperationError

interface OperationErrorProvider {
    fun getOperationError(cause: Throwable): OperationError
}
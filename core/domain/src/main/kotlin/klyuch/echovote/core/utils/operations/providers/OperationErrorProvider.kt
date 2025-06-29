package klyuch.echovote.core.utils.operations.providers

import klyuch.echovote.core.utils.operations.models.OperationError

interface OperationErrorProvider {
    fun getOperationError(cause: Throwable): OperationError
}
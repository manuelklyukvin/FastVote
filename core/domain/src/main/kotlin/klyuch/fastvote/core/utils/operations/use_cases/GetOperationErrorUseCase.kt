package klyuch.fastvote.core.utils.operations.use_cases

import klyuch.fastvote.core.utils.operations.providers.OperationErrorProvider

class GetOperationErrorUseCase(private val operationErrorProvider: OperationErrorProvider) {
    operator fun invoke(cause: Throwable) = operationErrorProvider.getOperationError(cause)
}
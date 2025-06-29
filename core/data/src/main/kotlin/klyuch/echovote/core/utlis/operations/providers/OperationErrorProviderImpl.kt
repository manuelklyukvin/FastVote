package klyuch.echovote.core.utlis.operations.providers

import klyuch.echovote.core.utils.operations.models.OperationError
import klyuch.echovote.core.utils.operations.providers.OperationErrorProvider
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import kotlin.coroutines.cancellation.CancellationException

class OperationErrorProviderImpl : OperationErrorProvider {
    override fun getOperationError(cause: Throwable) = when (cause) {
        is CancellationException -> throw cause
        is ConnectException -> OperationError.Network
        is SocketTimeoutException -> OperationError.ServerUnavailable
        is HttpException -> when (cause.code()) {
            400 -> OperationError.BadRequest
            404 -> OperationError.NotFound
            else -> OperationError.Internal
        }
        else -> OperationError.Unknown
    }
}
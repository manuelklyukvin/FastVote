package klyuch.echovote.app.di.modules

import klyuch.echovote.core.utils.operations.mappers.OperationErrorMapper
import klyuch.echovote.core.utils.operations.providers.OperationErrorProvider
import klyuch.echovote.core.utils.operations.use_cases.GetOperationErrorUseCase
import klyuch.echovote.core.utlis.operations.providers.OperationErrorProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModule = module {
    singleOf(::OperationErrorProviderImpl) bind OperationErrorProvider::class
    singleOf(::GetOperationErrorUseCase)
    singleOf(::OperationErrorMapper)
}
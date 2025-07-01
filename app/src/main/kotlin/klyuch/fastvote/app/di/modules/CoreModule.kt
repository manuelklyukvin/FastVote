package klyuch.fastvote.app.di.modules

import klyuch.fastvote.core.utils.operations.mappers.OperationErrorMapper
import klyuch.fastvote.core.utils.operations.providers.OperationErrorProvider
import klyuch.fastvote.core.utils.operations.use_cases.GetOperationErrorUseCase
import klyuch.fastvote.core.utlis.operations.providers.OperationErrorProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModule = module {
    singleOf(::OperationErrorProviderImpl) bind OperationErrorProvider::class
    singleOf(::GetOperationErrorUseCase)
    singleOf(::OperationErrorMapper)
}
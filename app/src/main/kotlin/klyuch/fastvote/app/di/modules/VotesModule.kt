package klyuch.fastvote.app.di.modules

import klyuch.fastvote.core.api.Api
import klyuch.fastvote.votes.data_sources.RemoteVotesDataSource
import klyuch.fastvote.votes.repositories.VotesRepository
import klyuch.fastvote.votes.repositories.VotesRepositoryImpl
import klyuch.fastvote.votes.use_cases.GetVotesUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val votesModule = module {
    single { Api.retrofit.create(RemoteVotesDataSource::class.java) }
    singleOf(::VotesRepositoryImpl) bind VotesRepository::class
    singleOf(::GetVotesUseCase)
}
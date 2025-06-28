package klyuch.echovote.app.di.modules

import klyuch.echovote.core.api.Api
import klyuch.echovote.votes.data_sources.RemoteVotesDataSource
import klyuch.echovote.votes.repositories.VotesRepository
import klyuch.echovote.votes.repositories.VotesRepositoryImpl
import klyuch.echovote.votes.use_cases.GetVotesUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val votesModule = module {
    single { Api.retrofit.create(RemoteVotesDataSource::class.java) }
    singleOf(::VotesRepositoryImpl) bind VotesRepository::class
    singleOf(::GetVotesUseCase)
}
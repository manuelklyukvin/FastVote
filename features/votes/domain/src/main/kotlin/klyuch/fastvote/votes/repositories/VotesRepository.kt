package klyuch.fastvote.votes.repositories

import klyuch.fastvote.votes.models.DomainVote
import kotlinx.coroutines.flow.Flow

interface VotesRepository {
    suspend fun getVotes(): Flow<List<DomainVote>>
}
package klyuch.echovote.votes.repositories

import klyuch.echovote.votes.models.DomainVote
import kotlinx.coroutines.flow.Flow

interface VotesRepository {
    suspend fun getVotes(): Flow<List<DomainVote>>
}
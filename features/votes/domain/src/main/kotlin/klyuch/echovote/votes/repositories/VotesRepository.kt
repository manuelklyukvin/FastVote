package klyuch.echovote.votes.repositories

import klyuch.echovote.votes.models.DomainVote

interface VotesRepository {
    suspend fun getVotes(): List<DomainVote>
}
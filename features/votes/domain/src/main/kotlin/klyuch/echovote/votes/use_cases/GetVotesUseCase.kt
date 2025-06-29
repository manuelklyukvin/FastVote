package klyuch.echovote.votes.use_cases

import klyuch.echovote.core.utils.operations.models.OperationResult
import klyuch.echovote.votes.models.DomainVote
import klyuch.echovote.votes.repositories.VotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class GetVotesUseCase(private val votesRepository: VotesRepository) {
    suspend operator fun invoke() = votesRepository.getVotes()
        .map<List<DomainVote>, OperationResult<List<DomainVote>, String?>> { OperationResult.Success(it) }
        .catch { emit(OperationResult.Error(it.message)) }
        .flowOn(Dispatchers.IO)
}
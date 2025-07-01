package klyuch.fastvote.votes.use_cases

import klyuch.fastvote.core.utils.operations.models.OperationError
import klyuch.fastvote.core.utils.operations.models.OperationResult
import klyuch.fastvote.core.utils.operations.use_cases.GetOperationErrorUseCase
import klyuch.fastvote.votes.models.DomainVote
import klyuch.fastvote.votes.repositories.VotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class GetVotesUseCase(
    private val votesRepository: VotesRepository,
    private val getOperationErrorUseCase: GetOperationErrorUseCase
) {
    suspend operator fun invoke() = votesRepository.getVotes()
        .map { OperationResult.Success(it) as OperationResult<List<DomainVote>, OperationError> }
        .catch { emit(OperationResult.Error(getOperationErrorUseCase(it))) }
        .flowOn(Dispatchers.IO)
}
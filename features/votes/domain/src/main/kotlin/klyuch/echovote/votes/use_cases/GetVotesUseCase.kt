package klyuch.echovote.votes.use_cases

import klyuch.echovote.core.utils.operations.models.OperationError
import klyuch.echovote.core.utils.operations.models.OperationResult
import klyuch.echovote.core.utils.operations.use_cases.GetOperationErrorUseCase
import klyuch.echovote.votes.models.DomainVote
import klyuch.echovote.votes.repositories.VotesRepository
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
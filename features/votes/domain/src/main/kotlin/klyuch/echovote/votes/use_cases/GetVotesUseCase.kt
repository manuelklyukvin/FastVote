package klyuch.echovote.votes.use_cases

import klyuch.echovote.core.utils.operations.models.OperationResult
import klyuch.echovote.votes.repositories.VotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetVotesUseCase(private val votesRepository: VotesRepository) {
    suspend operator fun invoke() = try {
        val votes = withContext(Dispatchers.IO) {
            votesRepository.getVotes()
        }
        OperationResult.Success(votes)
    } catch (e: Exception) {
        OperationResult.Error(e)
    }
}
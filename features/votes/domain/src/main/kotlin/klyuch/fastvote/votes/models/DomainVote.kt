package klyuch.fastvote.votes.models

data class DomainVote(
    val id: Long,
    val imageUrl: String?,
    val voteUser: DomainVoteUser,
    val title: String,
    val description: String,
    val tags: List<String>,
    val selectedAnswerId: Long?,
    val answers: List<DomainAnswer>
)
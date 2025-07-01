package klyuch.fastvote.votes.models

data class DomainAnswer(
    val id: Long,
    val name: String,
    val votesCount: Int
)
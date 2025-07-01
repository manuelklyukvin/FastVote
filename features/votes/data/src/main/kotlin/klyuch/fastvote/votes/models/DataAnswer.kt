package klyuch.fastvote.votes.models

data class DataAnswer(
    val id: Long,
    val name: String,
    val votesCount: Int
)

fun DataAnswer.toDomain() = DomainAnswer(
    id = id,
    name = name,
    votesCount = votesCount
)
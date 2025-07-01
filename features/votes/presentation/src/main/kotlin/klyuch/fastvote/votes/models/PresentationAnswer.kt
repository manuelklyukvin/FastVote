package klyuch.fastvote.votes.models

data class PresentationAnswer(
    val id: Long,
    val name: String,
    val votesCount: Int
)

fun DomainAnswer.toPresentation() = PresentationAnswer(
    id = id,
    name = name,
    votesCount = votesCount
)
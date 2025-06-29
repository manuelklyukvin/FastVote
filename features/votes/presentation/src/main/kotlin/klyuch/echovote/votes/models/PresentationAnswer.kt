package klyuch.echovote.votes.models

data class PresentationAnswer(
    val id: Long,
    val name: String,
    val count: Int
)

fun DomainAnswer.toPresentation() = PresentationAnswer(
    id = id,
    name = name,
    count = count
)
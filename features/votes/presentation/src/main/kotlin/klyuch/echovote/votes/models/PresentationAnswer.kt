package klyuch.echovote.votes.models

data class PresentationAnswer(
    val name: String,
    val count: Int
)

fun DomainAnswer.toPresentation() = PresentationAnswer(name, count)
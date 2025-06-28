package klyuch.echovote.votes.models

data class DataAnswer(
    val name: String,
    val count: Int
)

fun DataAnswer.toDomain() = DomainAnswer(name, count)
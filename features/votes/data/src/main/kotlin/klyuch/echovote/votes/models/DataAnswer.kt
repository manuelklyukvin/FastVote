package klyuch.echovote.votes.models

data class DataAnswer(
    val id: Long,
    val name: String,
    val count: Int
)

fun DataAnswer.toDomain() = DomainAnswer(
    id = id,
    name = name,
    count = count
)
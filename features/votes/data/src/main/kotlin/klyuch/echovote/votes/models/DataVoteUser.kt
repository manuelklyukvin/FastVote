package klyuch.echovote.votes.models

data class DataVoteUser(
    val id: Long,
    val avatarUrl: String?,
    val name: String
)

fun DataVoteUser.toDomain() = DomainVoteUser(
    id = id,
    avatarUrl = avatarUrl,
    name = name
)
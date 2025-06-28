package klyuch.echovote.votes.models

data class PresentationVoteUser(
    val id: Long,
    val avatarUrl: String?,
    val name: String
)

fun DomainVoteUser.toPresentation() = PresentationVoteUser(
    id = id,
    avatarUrl = avatarUrl,
    name = name
)
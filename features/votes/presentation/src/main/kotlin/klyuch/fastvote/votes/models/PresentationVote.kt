package klyuch.fastvote.votes.models

data class PresentationVote(
    val id: Long,
    val imageUrl: String?,
    val voteUser: PresentationVoteUser,
    val title: String,
    val description: String,
    val tags: List<String>,
    val selectedAnswerId: Long?,
    val answers: List<PresentationAnswer>
)

fun DomainVote.toPresentation() = PresentationVote(
    id = id,
    imageUrl = imageUrl,
    voteUser = voteUser.toPresentation(),
    title = title,
    description = description,
    tags = tags,
    selectedAnswerId = selectedAnswerId,
    answers = answers.map { it.toPresentation() }
)
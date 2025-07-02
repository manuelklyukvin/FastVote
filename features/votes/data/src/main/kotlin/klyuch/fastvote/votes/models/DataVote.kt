package klyuch.fastvote.votes.models

data class DataVote(
    val id: Long,
    val imageUrl: String?,
    val voteUser: DataVoteUser,
    val title: String,
    val description: String,
    val tags: List<String>,
    val selectedAnswerId: Long?,
    val answers: List<DataAnswer>
)

fun DataVote.toDomain() = DomainVote(
    id = id,
    imageUrl = imageUrl,
    voteUser = voteUser.toDomain(),
    title = title,
    description = description,
    tags = tags,
    selectedAnswerId = selectedAnswerId,
    answers = answers.map { it.toDomain() }
)
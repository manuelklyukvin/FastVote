package klyuch.echovote.votes.repositories

import klyuch.echovote.votes.data_sources.RemoteVotesDataSource
import klyuch.echovote.votes.models.DataAnswer
import klyuch.echovote.votes.models.DataVote
import klyuch.echovote.votes.models.DataVoteUser
import klyuch.echovote.votes.models.toDomain
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class VotesRepositoryImpl(private val remoteVotesDataSource: RemoteVotesDataSource) : VotesRepository {
    override suspend fun getVotes() = flow {
        delay(2000)

        val defaultVote = DataVote(
            id = 0,
            imageUrl = null,
            voteUser = DataVoteUser(
                id = 0,
                avatarUrl = null,
                name = "User"
            ),
            title = "Стоит ли мне перестать бить жену и детей?",
            description = "Тут я типо описываю всю ситуацию, чтобы юзеры смогли прочитать и проголосовать, а еще надо побольше текста, чтобы понять, как оно будет выглядеть",
            tags = listOf("семья", "дом", "дети"),
            answers = listOf(
                DataAnswer(0, "Нет", 100),
                DataAnswer(1, "Ни в коем случае", 150)
            )
        )

        emit(
            listOf(
                defaultVote.copy(description = "Описание в одну строку"),
                defaultVote.copy(imageUrl = "", description = defaultVote.description + defaultVote.description + defaultVote.description),
                defaultVote.copy(imageUrl = ""),
                defaultVote.copy(
                    tags = listOf(
                        "семья",
                        "дети",
                        "крепкийбрак",
                        "дом",
                        "любовь",
                        "патриархат",
                        "MANMANMAN",
                        "хочувреки",
                        "попес"
                    )
                ),
                defaultVote.copy(imageUrl = ""),
            ).map { it.toDomain() }
        )
    }
}
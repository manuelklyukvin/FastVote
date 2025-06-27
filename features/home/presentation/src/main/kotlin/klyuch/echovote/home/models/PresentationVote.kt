package klyuch.echovote.home.models

data class PresentationVote(
    val id: Long = 0,
    val imageUrl: String? = null,
    val homeUser: PresentationHomeUser = PresentationHomeUser(0, null, "User"),
    val title: String = "Стоит ли мне перестать бить жену и детей?",
    val description: String = "Тут я типо описываю всю ситуацию, чтобы юзеры смогли прочитать и проголосовать, а еще надо побольше текста, чтобы понять, как оно будет выглядеть",
    val tags: List<String> = listOf("семья", "дом", "дети"),
    val answers: List<PresentationAnswer> = listOf(
        PresentationAnswer("Нет", 100),
        PresentationAnswer("Ни в коем случае", 150)
    )
)
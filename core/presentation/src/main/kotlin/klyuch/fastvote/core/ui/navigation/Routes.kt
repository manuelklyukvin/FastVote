package klyuch.fastvote.core.ui.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object HomeBlock : Routes()
    @Serializable
    data object Home : Routes()

    @Serializable
    data object PostVoteBlock : Routes()
    @Serializable
    data object PostVote : Routes()

    @Serializable
    data object ProfileBlock : Routes()
    @Serializable
    data object Profile : Routes()
}
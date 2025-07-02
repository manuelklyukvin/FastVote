package klyuch.fastvote.home.ui.screens

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import klyuch.fastvote.core.ui.components.AppCard
import klyuch.fastvote.core.ui.components.images.AppIcon
import klyuch.fastvote.core.ui.components.images.AppImage
import klyuch.fastvote.core.ui.components.texts.AppLineText
import klyuch.fastvote.core.ui.components.texts.AppText
import klyuch.fastvote.core.ui.theme.AppTheme
import klyuch.fastvote.core.ui.utils.HorizontalSpacer
import klyuch.fastvote.core.ui.utils.VerticalSpacer
import klyuch.fastvote.core.ui.utils.noIndicationClickable
import klyuch.fastvote.home.R
import klyuch.fastvote.home.ui.view_models.models.HomeIntent
import klyuch.fastvote.home.ui.view_models.models.HomeState
import klyuch.fastvote.votes.models.PresentationAnswer
import klyuch.fastvote.votes.models.PresentationVote
import klyuch.fastvote.votes.models.PresentationVoteUser
import klyuch.fastvote.core.R as CoreR

@Composable
internal fun ContentHomeScreen(state: HomeState, onIntent: (HomeIntent) -> Unit) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = rememberPagerState(pageCount = { state.votes.size })
    ) { page ->
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = AppTheme.shapes.screenPadding)
                .clip(AppTheme.shapes.roundedCornerShape),
            verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingNormal)
        ) {
            item { VoteCard(state.votes[page], onIntent) }
            item { Comments(state, onIntent) }
        }
    }
}

@Composable
private fun VoteCard(vote: PresentationVote, onIntent: (HomeIntent) -> Unit) {
    AppCard(
        modifier = Modifier.fillMaxWidth(),
        areDefaultPaddingsEnabled = false
    ) {
        vote.imageUrl?.let { imageUrl ->
            AppImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(AppTheme.shapes.roundedCornerShape),
                model = painterResource(R.drawable.img),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier.padding(AppTheme.shapes.paddingNormal),
            verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall)
        ) {
            VoteUser(vote.voteUser, onIntent)
            VoteText(vote)
            VoteTags(vote.tags, onIntent)
            VerticalSpacer(AppTheme.shapes.paddingSmall)
            VoteAnswers(vote, onIntent)
        }
    }
}

@Composable
private fun VoteUser(voteUser: PresentationVoteUser, onIntent: (HomeIntent) -> Unit) {
    Row(
        modifier = Modifier.noIndicationClickable { onIntent(HomeIntent.OnUserClicked(voteUser.id)) },
        horizontalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (voteUser.avatarUrl != null) {
            AppImage(
                modifier = Modifier
                    .size(AppTheme.shapes.sizeMedium)
                    .clip(AppTheme.shapes.roundCornerShape),
                model = voteUser.avatarUrl!!,
                contentScale = ContentScale.Crop
            )
        } else {
            AppIcon(
                modifier = Modifier.size(AppTheme.shapes.sizeMedium),
                model = painterResource(CoreR.drawable.profile)
            )
        }
        AppLineText(
            text = voteUser.name,
            style = AppTheme.typography.title,
            color = AppTheme.colorScheme.primary
        )
    }
}

@Composable
private fun VoteText(vote: PresentationVote) {
    AppText(
        text = vote.title,
        style = AppTheme.typography.headline
    )
    AppText(text = vote.description)
}

@Composable
private fun VoteTags(tags: List<String>, onIntent: (HomeIntent) -> Unit) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall)
    ) {
        tags.forEach { tag ->
            AppLineText(
                modifier = Modifier.noIndicationClickable { onIntent(HomeIntent.OnTagClicked(tag)) },
                text = "#$tag",
                color = AppTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun VoteAnswers(vote: PresentationVote, onIntent: (HomeIntent) -> Unit) {
    val totalVotes = vote.answers.sumOf { it.votesCount }

    Column(verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall)) {
        vote.answers.forEach { answer ->
            VoteAnswer(
                totalVotes = totalVotes,
                selectedAnswerId = vote.selectedAnswerId,
                answer = answer,
                onClick = { onIntent(HomeIntent.OnAnswerClicked(answer)) }
            )
        }
    }
}

@Composable
private fun VoteAnswer(
    totalVotes: Int,
    selectedAnswerId: Long?,
    answer: PresentationAnswer,
    onClick: () -> Unit
) {
    val votesPercentage = if (totalVotes != 0) {
        answer.votesCount.toFloat() / totalVotes
    } else 0f

    val animatedPercentage by animateFloatAsState(
        targetValue = if (selectedAnswerId != null) votesPercentage else 0f
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(AppTheme.shapes.sizeMedium)
            .clip(AppTheme.shapes.roundCornerShape)
            .background(AppTheme.colorScheme.background)
            .noIndicationClickable { if (selectedAnswerId == null) onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(animatedPercentage)
                .fillMaxHeight()
                .clip(AppTheme.shapes.roundCornerShape)
                .background(
                    if (answer.id == selectedAnswerId) {
                        AppTheme.colorScheme.primary
                    } else {
                        AppTheme.colorScheme.outline
                    }
                )
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = AppTheme.shapes.paddingSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AppLineText(
                modifier = Modifier
                    .clip(AppTheme.shapes.roundCornerShape)
                    .background(AppTheme.colorScheme.background)
                    .padding(
                        vertical = AppTheme.shapes.paddingExtraSmall,
                        horizontal = AppTheme.shapes.paddingNormal
                    ),
                text = answer.name
            )
            selectedAnswerId?.let {
                HorizontalSpacer(AppTheme.shapes.paddingNormal)
                AppLineText(text = "${answer.votesCount} • ${(votesPercentage * 100).toInt()}%")
            }
        }
    }
}

@Composable
private fun Comments(state: HomeState, onIntent: (HomeIntent) -> Unit) {
    AppCard(modifier = Modifier.fillMaxWidth()) {
        AppLineText(text = "Comments")
    }
}

@Preview
@Composable
private fun LightContentHomeScreenPreview() {
    ContentHomeScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkContentHomeScreenPreview() {
    ContentHomeScreenPreview()
}

@Composable
private fun ContentHomeScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            ContentHomeScreen(
                state = HomeState(
                    votes = List(5) {
                        PresentationVote(
                            id = 0,
                            imageUrl = null,
                            voteUser = PresentationVoteUser(0, null, "User"),
                            title = "Title title title",
                            description = "Description description description description description",
                            tags = listOf("tag", "tag", "tag"),
                            selectedAnswerId = 0,
                            answers = listOf(
                                PresentationAnswer(0, "Yes", 100),
                                PresentationAnswer(1, "No", 50),
                                PresentationAnswer(2, "Idk", 20)
                            ),
                        )
                    }
                ),
                onIntent = { }
            )
        }
    }
}
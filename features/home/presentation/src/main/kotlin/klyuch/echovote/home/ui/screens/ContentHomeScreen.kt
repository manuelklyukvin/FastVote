package klyuch.echovote.home.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import klyuch.echovote.core.ui.components.AppCard
import klyuch.echovote.core.ui.components.images.AppIcon
import klyuch.echovote.core.ui.components.images.AppImage
import klyuch.echovote.core.ui.components.texts.AppExpandableText
import klyuch.echovote.core.ui.components.texts.AppLineText
import klyuch.echovote.core.ui.components.texts.AppText
import klyuch.echovote.core.ui.theme.AppTheme
import klyuch.echovote.core.ui.utils.noIndicationClickable
import klyuch.echovote.home.R
import klyuch.echovote.home.ui.view_models.models.HomeIntent
import klyuch.echovote.home.ui.view_models.models.HomeState
import klyuch.echovote.votes.models.PresentationAnswer
import klyuch.echovote.votes.models.PresentationVote
import klyuch.echovote.votes.models.PresentationVoteUser
import klyuch.echovote.core.R as CoreR

@Composable
internal fun ContentHomeScreen(state: HomeState, onIntent: (HomeIntent) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.screenPadding)
            .clip(AppTheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingNormal)
    ) {
        items(state.votes) { vote ->
            VoteCard(vote, onIntent)
        }
    }
}

@Composable
private fun VoteCard(vote: PresentationVote, onIntent: (HomeIntent) -> Unit) {
    AppCard(
        modifier = Modifier.fillMaxWidth(),
        areDefaultPaddingsEnabled = false
    ) {
        vote.imageUrl?.let {
            AppImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
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
            Spacer(Modifier.height(AppTheme.shapes.paddingSmall))
            VoteAnswers(vote.answers, onIntent)
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
                    .clip(RoundedCornerShape(100)),
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
    AppExpandableText(
        text = vote.description,
        maxLines = 3
    )
}

@Composable
private fun VoteTags(tags: List<String>, onIntent: (HomeIntent) -> Unit) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall)
    ) {
        tags.forEach {
            AppLineText(
                modifier = Modifier.noIndicationClickable { onIntent(HomeIntent.OnTagClicked(it)) },
                text = "#$it",
                color = AppTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun VoteAnswers(answers: List<PresentationAnswer>, onIntent: (HomeIntent) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall)) {
        answers.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(100))
                    .background(AppTheme.colorScheme.background)
                    .padding(
                        vertical = AppTheme.shapes.paddingNormal,
                        horizontal = AppTheme.shapes.paddingMedium
                    )
                    .noIndicationClickable { onIntent(HomeIntent.OnAnswerClicked(it)) }
            ) {
                AppLineText(text = it.name)
            }
        }
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
                            answers = List(3) { PresentationAnswer(0, "Yes", 10) },
                        )
                    }
                ),
                onIntent = { }
            )
        }
    }
}
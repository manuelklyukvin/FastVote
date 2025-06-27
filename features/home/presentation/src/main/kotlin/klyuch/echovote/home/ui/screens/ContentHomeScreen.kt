package klyuch.echovote.home.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import klyuch.echovote.core.ui.components.AppCard
import klyuch.echovote.core.ui.components.images.AppIcon
import klyuch.echovote.core.ui.components.images.AppImage
import klyuch.echovote.core.ui.components.texts.AppLineText
import klyuch.echovote.core.ui.components.texts.AppText
import klyuch.echovote.core.ui.theme.AppTheme
import klyuch.echovote.core.ui.utils.noIndicationClickable
import klyuch.echovote.home.R
import klyuch.echovote.home.models.PresentationHomeUser
import klyuch.echovote.home.models.PresentationVote
import klyuch.echovote.home.ui.view_models.models.HomeIntent
import klyuch.echovote.home.ui.view_models.models.HomeState
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
        // TODO Тестовая логика
        vote.imageUrl?.let {
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
            HomeUser(vote.homeUser, onIntent)
            AppText(
                text = vote.title,
                style = AppTheme.typography.headline
            )
            AppText(
                text = vote.description,
                maxLines = 3
            )
            AppLineText(
                modifier = Modifier
                    .fillMaxWidth()
                    .noIndicationClickable { onIntent(HomeIntent.OnMoreButtonClicked) },
                text = stringResource(R.string.more_button),
                color = AppTheme.colorScheme.primary,
                textAlign = TextAlign.End
            )
            Tags(vote.tags, onIntent)
        }
    }
}

@Composable
private fun HomeUser(homeUser: PresentationHomeUser, onIntent: (HomeIntent) -> Unit) {
    Row(
        modifier = Modifier.noIndicationClickable { onIntent(HomeIntent.OnUserClicked(homeUser.id)) },
        horizontalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (homeUser.avatarUrl != null) {
            AppImage(
                modifier = Modifier
                    .size(AppTheme.shapes.sizeNormal)
                    .clip(RoundedCornerShape(100)),
                model = homeUser.avatarUrl,
                contentScale = ContentScale.Crop
            )
        } else {
            AppIcon(
                modifier = Modifier.size(AppTheme.shapes.sizeNormal),
                model = painterResource(CoreR.drawable.profile)
            )
        }
        AppLineText(
            text = homeUser.name,
            style = AppTheme.typography.title,
            color = AppTheme.colorScheme.primary
        )
    }
}

@Composable
private fun Tags(tags: List<String>, onIntent: (HomeIntent) -> Unit) {
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
                state = HomeState(),
                onIntent = { }
            )
        }
    }
}
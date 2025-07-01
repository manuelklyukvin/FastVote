package klyuch.fastvote.core.ui.components.scaffolds

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import klyuch.fastvote.core.R
import klyuch.fastvote.core.ui.components.images.AppIcon
import klyuch.fastvote.core.ui.theme.AppTheme
import klyuch.fastvote.core.ui.theme.localNavigationState
import klyuch.fastvote.core.ui.utils.noIndicationClickable

@Composable
fun AppTopBar() {
    val navigationState = localNavigationState.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = AppTheme.shapes.paddingSmall,
                horizontal = AppTheme.shapes.screenPadding
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppIcon(
            modifier = Modifier
                .size(AppTheme.shapes.sizeNormal)
                .noIndicationClickable { navigationState.navigateUp() },
            model = painterResource(R.drawable.arrow_back)
        )
    }
}

@Preview
@Composable
private fun LightAppTopBarPreview() {
    AppTopBarPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkAppTopBarPreview() {
    AppTopBarPreview()
}

@Composable
private fun AppTopBarPreview() {
    AppTheme {
        Surface(color = AppTheme.colorScheme.background) {
            AppTopBar()
        }
    }
}
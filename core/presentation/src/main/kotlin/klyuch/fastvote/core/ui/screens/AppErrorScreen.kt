package klyuch.fastvote.core.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import klyuch.fastvote.core.R
import klyuch.fastvote.core.ui.components.AppButton
import klyuch.fastvote.core.ui.components.texts.AppText
import klyuch.fastvote.core.ui.theme.AppTheme

@Composable
fun AppErrorScreen(error: Any?, onRetryButtonClicked: () -> Unit) {
    val errorMessage = when (error) {
        is Int -> stringResource(error)
        is String -> error
        else -> return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.shapes.paddingExtraLarge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppText(
            text = errorMessage,
            style = AppTheme.typography.title,
            color = AppTheme.colorScheme.error,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(AppTheme.shapes.paddingSmall))
        AppButton(
            text = stringResource(R.string.retry_button),
            onClick = onRetryButtonClicked
        )
    }
}

@Preview
@Composable
private fun LightAppErrorScreenPreview() {
    AppErrorScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkAppErrorScreenPreview() {
    AppErrorScreenPreview()
}

@Composable
private fun AppErrorScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            AppErrorScreen(
                error = "Something went wrong",
                onRetryButtonClicked = { }
            )
        }
    }
}
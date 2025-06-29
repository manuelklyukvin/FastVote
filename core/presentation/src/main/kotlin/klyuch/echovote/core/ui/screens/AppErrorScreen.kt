package klyuch.echovote.core.ui.screens

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
import klyuch.echovote.core.R
import klyuch.echovote.core.ui.components.AppButton
import klyuch.echovote.core.ui.components.texts.AppText
import klyuch.echovote.core.ui.theme.AppTheme

@Composable
fun AppErrorScreen(error: Any?, onRetryButtonClicked: () -> Unit) {
    val errorMessage = when (error) {
        is Int -> stringResource(error)
        is String -> error
        else -> return
    }
    AppErrorScreen(errorMessage, onRetryButtonClicked)
}

@Composable
private fun AppErrorScreen(errorMessage: String, onRetryButtonClicked: () -> Unit) {
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
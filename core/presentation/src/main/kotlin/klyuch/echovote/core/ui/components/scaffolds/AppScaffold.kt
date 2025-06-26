package klyuch.echovote.core.ui.components.scaffolds

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import klyuch.echovote.core.ui.theme.AppTheme

@Composable
fun AppScaffold(content: @Composable () -> Unit) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        containerColor = Color.Transparent,
        bottomBar = { AppNavBar() }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            content()
        }
    }
}

@Preview
@Composable
private fun LightAppScaffoldPreview() {
    AppScaffoldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkAppScaffoldPreview() {
    AppScaffoldPreview()
}

@Composable
private fun AppScaffoldPreview() {
    AppTheme {
        Surface(color = AppTheme.colorScheme.background) {
            AppScaffold { }
        }
    }
}
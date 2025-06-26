package klyuch.echovote.core.ui.components.images

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import klyuch.echovote.core.ui.theme.AppTheme

@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    model: Painter,
    tint: Color = AppTheme.colorScheme.primary
) {
    Icon(
        modifier = modifier,
        painter = model,
        tint = tint,
        contentDescription = null
    )
}
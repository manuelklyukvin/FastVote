package klyuch.echovote.core.ui.components.images

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    model: Any,
    contentScale: ContentScale = ContentScale.Fit
) {
    if (model is Painter) {
        Image(
            modifier = modifier,
            painter = model,
            contentScale = contentScale,
            contentDescription = null
        )
    } else {
        AsyncImage(
            modifier = modifier,
            model = model,
            contentScale = contentScale,
            contentDescription = null
        )
    }
}
package klyuch.fastvote.core.ui.components.texts

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import io.dokar.expandabletext.ExpandableText
import klyuch.fastvote.core.R
import klyuch.fastvote.core.ui.theme.AppTheme
import klyuch.fastvote.core.ui.utils.noIndicationClickable

@Composable
fun AppExpandableText(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int
) {
    var isExpanded by remember { mutableStateOf(false) }

    val baseTextStyle = AppTheme.typography.body
    val baseSpanStyle = SpanStyle(
        fontFamily = baseTextStyle.fontFamily,
        fontSize = baseTextStyle.fontSize,
        color = baseTextStyle.color
    )

    ExpandableText(
        modifier = modifier.animateContentSize(),
        text = text,
        expanded = isExpanded,
        collapsedMaxLines = maxLines,
        style = baseTextStyle,
        toggle = {
            Text(
                modifier = Modifier.noIndicationClickable { isExpanded = !isExpanded },
                text = if (isExpanded) {
                    buildAnnotatedString {
                        withStyle(baseSpanStyle.copy(color = AppTheme.colorScheme.primary)) {
                            append(" " + stringResource(R.string.show_less_button))
                        }
                    }
                } else {
                    buildAnnotatedString {
                        withStyle(baseSpanStyle) {
                            append("... ")
                            withStyle(SpanStyle(color = AppTheme.colorScheme.primary)) {
                                append(stringResource(R.string.show_more_button))
                            }
                        }
                    }
                }
            )
        }
    )
}

@Preview
@Composable
private fun LightAppExpandableTextPreview() {
    AppExpandableTextPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkAppExpandableTextPreview() {
    AppExpandableTextPreview()
}

@Composable
private fun AppExpandableTextPreview() {
    AppTheme {
        Surface(color = AppTheme.colorScheme.surface) {
            AppExpandableText(
                text = "Preview Preview Preview Preview Preview Preview Preview",
                maxLines = 1
            )
        }
    }
}
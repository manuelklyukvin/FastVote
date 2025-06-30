package klyuch.echovote.core.ui.components.texts

import androidx.compose.animation.animateContentSize
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
import io.dokar.expandabletext.ExpandableText
import klyuch.echovote.core.R
import klyuch.echovote.core.ui.theme.AppTheme
import klyuch.echovote.core.ui.utils.noIndicationClickable

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
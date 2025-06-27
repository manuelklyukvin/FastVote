package klyuch.echovote.core.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import klyuch.echovote.core.ui.components.texts.AppLineText
import klyuch.echovote.core.ui.theme.AppTheme

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String? = null,
    isEnabled: Boolean = true,
    isPrimary: Boolean = true,
    content: @Composable (() -> Unit)? = null
) {
    val containerColor: Color
    val contentColor: Color

    if (isPrimary) {
        containerColor = AppTheme.colorScheme.primary
        contentColor = AppTheme.colorScheme.onPrimary
    } else {
        containerColor = Color.Transparent
        contentColor = AppTheme.colorScheme.primary
    }

    val alpha = 0.5f
    val disabledContainerColor = containerColor.copy(alpha = alpha)
    val disabledContentColor = contentColor.copy(alpha = alpha)

    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled,
        shape = AppTheme.shapes.roundedCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        ),
        border = if (isPrimary) null else BorderStroke(1.dp, contentColor),
        contentPadding = PaddingValues(
            horizontal = AppTheme.shapes.paddingExtraLarge,
            vertical = AppTheme.shapes.paddingMedium
        )
    ) {
        if (text != null) {
            AppLineText(
                text = text,
                color = if (isEnabled) contentColor else disabledContentColor
            )
        } else if (content != null) content()
    }
}

@Preview
@Composable
private fun LightPrimaryAppButtonPreview() {
    PrimaryAppButtonPreview()
}

@Preview
@Composable
private fun LightSecondaryAppButtonPreview() {
    SecondaryAppButtonPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkPrimaryAppButtonPreview() {
    PrimaryAppButtonPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkSecondaryAppButtonPreview() {
    SecondaryAppButtonPreview()
}

@Composable
private fun PrimaryAppButtonPreview() {
    AppTheme {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            AppButton(
                text = "Enabled",
                onClick = { }
            )
            AppButton(
                text = "Disabled",
                onClick = { },
                isEnabled = false
            )
        }
    }
}

@Composable
private fun SecondaryAppButtonPreview() {
    AppTheme {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            AppButton(
                text = "Enabled",
                onClick = { },
                isPrimary = false
            )
            AppButton(
                text = "Disabled",
                onClick = { },
                isEnabled = false,
                isPrimary = false
            )
        }
    }
}
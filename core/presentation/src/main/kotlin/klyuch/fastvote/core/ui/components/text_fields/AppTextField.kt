package klyuch.fastvote.core.ui.components.text_fields

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import klyuch.fastvote.core.R
import klyuch.fastvote.core.ui.components.AppCard
import klyuch.fastvote.core.ui.components.images.AppIcon
import klyuch.fastvote.core.ui.components.texts.AppLineText
import klyuch.fastvote.core.ui.theme.AppTheme

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    isPrimary: Boolean = true,
    label: String? = null,
    hint: String? = null,
    error: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    maxLength: Int? = null,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    CoreTextField(
        modifier = modifier,
        state = state,
        label = label,
        textField = {
            TextField(
                state = state,
                isPrimary = isPrimary,
                hint = hint,
                error = error,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                keyboardType = keyboardType
            )
        },
        error = error,
        maxLength = maxLength
    )
}

@Composable
private fun TextField(
    state: TextFieldState,
    isPrimary: Boolean,
    hint: String?,
    error: String?,
    leadingIcon: (@Composable () -> Unit)?,
    trailingIcon: (@Composable () -> Unit)?,
    keyboardType: KeyboardType
) {
    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isPrimary) {
                    AppTheme.colorScheme.surface
                } else {
                    AppTheme.colorScheme.background
                },
                shape = AppTheme.shapes.roundCornerShape
            )
            .let { modifier ->
                if (error != null) modifier.border(
                    width = 1.dp,
                    color = AppTheme.colorScheme.error,
                    shape = AppTheme.shapes.roundCornerShape
                ) else modifier
            }
            .padding(AppTheme.shapes.paddingNormal),
        state = state,
        textStyle = AppTheme.typography.body,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        lineLimits = TextFieldLineLimits.SingleLine,
        cursorBrush = SolidColor(AppTheme.colorScheme.primary),
        decorator = { inputField ->
            Decorator(
                state = state,
                inputField = inputField,
                hint = hint,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon
            )
        }
    )
}

@Composable
private fun Decorator(
    state: TextFieldState,
    inputField: @Composable () -> Unit,
    hint: String?,
    leadingIcon: (@Composable () -> Unit)?,
    trailingIcon: (@Composable () -> Unit)?
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingNormal)
    ) {
        leadingIcon?.let { leadingIcon -> leadingIcon() }
        Box(modifier = Modifier.weight(1f)) {
            inputField()
            if (state.text.isEmpty() && hint != null) {
                AppLineText(
                    text = hint,
                    color = AppTheme.colorScheme.outline
                )
            }
        }
        trailingIcon?.let { trailingIcon -> trailingIcon() }
    }
}

@Preview
@Composable
private fun PrimaryLightAppTextFieldPreview() {
    PrimaryAppTextFieldPreview()
}

@Preview
@Composable
private fun SecondaryLightAppTextFieldPreview() {
    SecondaryAppTextFieldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PrimaryDarkAppTextFieldPreview() {
    PrimaryAppTextFieldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SecondaryDarkAppTextFieldPreview() {
    SecondaryAppTextFieldPreview()
}

@Composable
private fun PrimaryAppTextFieldPreview() {
    AppTheme {
        Column(
            modifier = Modifier.background(AppTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AppTextField(state = TextFieldState("Preview"))
            AppTextField(
                state = TextFieldState("Preview"),
                label = "Label"
            )
            AppTextField(
                state = TextFieldState(),
                hint = "Hint"
            )
            AppTextField(
                state = TextFieldState(),
                error = "Error"
            )
            AppTextField(
                state = TextFieldState(),
                leadingIcon = {
                    AppIcon(
                        modifier = Modifier.size(AppTheme.shapes.sizeSmall),
                        model = painterResource(R.drawable.search)
                    )
                }
            )
            AppTextField(
                state = TextFieldState(),
                trailingIcon = {
                    AppIcon(
                        modifier = Modifier.size(AppTheme.shapes.sizeSmall),
                        model = painterResource(R.drawable.search)
                    )
                }
            )
            AppTextField(
                state = TextFieldState(),
                leadingIcon = {
                    AppIcon(
                        modifier = Modifier.size(AppTheme.shapes.sizeSmall),
                        model = painterResource(R.drawable.search)
                    )
                },
                trailingIcon = {
                    AppIcon(
                        modifier = Modifier.size(AppTheme.shapes.sizeSmall),
                        model = painterResource(R.drawable.search)
                    )
                }
            )
        }
    }
}

@Composable
private fun SecondaryAppTextFieldPreview() {
    AppTheme {
        AppCard(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            AppTextField(
                isPrimary = false,
                state = TextFieldState("Preview")
            )
            AppTextField(
                isPrimary = false,
                state = TextFieldState("Preview"),
                label = "Label"
            )
            AppTextField(
                isPrimary = false,
                state = TextFieldState(),
                hint = "Hint"
            )
            AppTextField(
                isPrimary = false,
                state = TextFieldState(),
                error = "Error"
            )
            AppTextField(
                isPrimary = false,
                state = TextFieldState(),
                leadingIcon = {
                    AppIcon(
                        modifier = Modifier.size(AppTheme.shapes.sizeSmall),
                        model = painterResource(R.drawable.search)
                    )
                }
            )
            AppTextField(
                isPrimary = false,
                state = TextFieldState(),
                trailingIcon = {
                    AppIcon(
                        modifier = Modifier.size(AppTheme.shapes.sizeSmall),
                        model = painterResource(R.drawable.search)
                    )
                }
            )
            AppTextField(
                isPrimary = false,
                state = TextFieldState(),
                leadingIcon = {
                    AppIcon(
                        modifier = Modifier.size(AppTheme.shapes.sizeSmall),
                        model = painterResource(R.drawable.search)
                    )
                },
                trailingIcon = {
                    AppIcon(
                        modifier = Modifier.size(AppTheme.shapes.sizeSmall),
                        model = painterResource(R.drawable.search)
                    )
                }
            )
        }
    }
}
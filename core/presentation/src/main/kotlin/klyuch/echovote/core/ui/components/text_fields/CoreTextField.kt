package klyuch.echovote.core.ui.components.text_fields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import klyuch.echovote.core.ui.components.texts.AppLineText
import klyuch.echovote.core.ui.components.texts.AppText
import klyuch.echovote.core.ui.theme.AppTheme

@Composable
internal fun CoreTextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    label: String? = null,
    textField: @Composable () -> Unit,
    error: String? = null,
    maxLength: Int? = null
) {
    maxLength?.let {
        val valueLength = state.text.length

        LaunchedEffect(valueLength) {
            if (valueLength > it) {
                state.edit { delete(it, valueLength) }
            }
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall)
    ) {
        label?.let {
            AppLineText(
                text = it,
                color = AppTheme.colorScheme.outline
            )
        }
        textField()
        error?.let {
            AppText(
                text = it,
                color = AppTheme.colorScheme.error
            )
        }
    }
}
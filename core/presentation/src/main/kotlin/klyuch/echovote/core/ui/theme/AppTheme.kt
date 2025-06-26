package klyuch.echovote.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import klyuch.echovote.core.R
import klyuch.echovote.core.ui.navigation.NavigationState
import klyuch.echovote.core.ui.navigation.rememberNavigationState
import klyuch.echovote.core.ui.theme.resources.Fonts

val localNavigationState = staticCompositionLocalOf<NavigationState> { error("No NavigationState provided") }
private val localColorScheme = staticCompositionLocalOf<AppColorScheme> { error("No ColorScheme provided") }
private val localShapes = staticCompositionLocalOf<AppShapes> { error("No Shapes provided") }
private val localTypography = staticCompositionLocalOf<AppTypography> { error("No Typography provided") }

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colorScheme = AppColorScheme(
        primary = colorResource(R.color.primary),
        onPrimary = colorResource(R.color.on_primary),
        secondary = colorResource(R.color.secondary),
        onSecondary = colorResource(R.color.on_secondary),
        error = colorResource(R.color.error),
        background = colorResource(R.color.background),
        onBackground = colorResource(R.color.on_background),
        surface = colorResource(R.color.surface),
        onSurface = colorResource(R.color.on_surface),
        outline = colorResource(R.color.outline)
    )

    val typography = AppTypography(
        label = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            color = colorScheme.onBackground,
            fontSize = 12.sp
        ),
        body = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            color = colorScheme.onBackground,
            fontSize = 14.sp
        ),
        title = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            color = colorScheme.onBackground,
            fontSize = 18.sp
        ),
        headline = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            color = colorScheme.onBackground,
            fontSize = 24.sp
        )
    )

    val shapes = AppShapes(
        screenPadding = 12.dp,
        roundedCornerShape = RoundedCornerShape(12.dp),

        paddingExtraSmall = 4.dp,
        paddingSmall = 8.dp,
        paddingMedium = 12.dp,
        paddingLarge = 16.dp,
        paddingExtraLarge = 20.dp,

        sizeExtraSmall = 16.dp,
        sizeSmall = 24.dp,
        sizeMedium = 32.dp,
        sizeLarge = 48.dp,
        sizeExtraLarge = 64.dp
    )

    CompositionLocalProvider(
        localNavigationState provides rememberNavigationState(),
        localColorScheme provides colorScheme,
        localShapes provides shapes,
        localTypography provides typography,
        content = content
    )
}

object AppTheme {
    val colorScheme @Composable get() = localColorScheme.current
    val shapes @Composable get() = localShapes.current
    val typography @Composable get() = localTypography.current
}
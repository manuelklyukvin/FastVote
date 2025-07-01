package klyuch.fastvote.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import klyuch.fastvote.core.R
import klyuch.fastvote.core.ui.navigation.NavigationState
import klyuch.fastvote.core.ui.navigation.rememberNavigationState
import klyuch.fastvote.core.ui.theme.resources.Fonts

val localNavigationState = staticCompositionLocalOf<NavigationState> { error("Navigation state not provided") }
private val localColorScheme = staticCompositionLocalOf<AppColorScheme> { error("Color scheme not provided") }
private val localShapes = staticCompositionLocalOf<AppShapes> { error("Shapes not provided") }
private val localTypography = staticCompositionLocalOf<AppTypography> { error("Typography not provided") }

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colorScheme = AppColorScheme(
        primary = colorResource(R.color.primary),
        onPrimary = colorResource(R.color.on_primary),

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
            fontSize = 16.sp
        ),
        headline = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            color = colorScheme.onBackground,
            fontSize = 20.sp
        ),
        display = TextStyle(
            fontFamily = Fonts.ptSansCaption,
            color = colorScheme.onBackground,
            fontSize = 24.sp
        )
    )

    val shapes = AppShapes(
        paddingExtraSmall = 4.dp,
        paddingSmall = 8.dp,
        paddingNormal = 12.dp,
        paddingMedium = 16.dp,
        paddingLarge = 20.dp,
        paddingExtraLarge = 24.dp,

        sizeExtraSmall = 16.dp,
        sizeSmall = 24.dp,
        sizeNormal = 32.dp,
        sizeMedium = 40.dp,
        sizeLarge = 48.dp,
        sizeExtraLarge = 56.dp,

        screenPadding = 12.dp,
        roundedCornerShape = RoundedCornerShape(12.dp),
        roundCornerShape = RoundedCornerShape(100)
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
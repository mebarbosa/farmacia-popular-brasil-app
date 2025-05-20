package com.buscar.farmaciapopular.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.buscar.farmaciapopular.R

@Composable
private fun lightColorSchemeFromResources(): ColorScheme =
    lightColorScheme(
        primary = colorResource(R.color.primary),
        onPrimary = colorResource(R.color.on_primary),
        primaryContainer = colorResource(R.color.primary_container),
        onPrimaryContainer = colorResource(R.color.on_primary_container),
        secondary = colorResource(R.color.secondary),
        onSecondary = colorResource(R.color.on_secondary),
        secondaryContainer = colorResource(R.color.secondary_container),
        onSecondaryContainer = colorResource(R.color.on_secondary_container),
        tertiary = colorResource(R.color.tertiary),
        onTertiary = colorResource(R.color.on_tertiary),
        tertiaryContainer = colorResource(R.color.tertiary_container),
        onTertiaryContainer = colorResource(R.color.on_tertiary_container),
        error = colorResource(R.color.error),
        onError = colorResource(R.color.on_error),
        errorContainer = colorResource(R.color.error_container),
        onErrorContainer = colorResource(R.color.on_error_container),
        background = colorResource(R.color.background),
        onBackground = colorResource(R.color.on_background),
        surface = colorResource(R.color.surface),
        onSurface = colorResource(R.color.on_surface),
        surfaceVariant = colorResource(R.color.surface_variant),
        onSurfaceVariant = colorResource(R.color.on_surface_variant),
        outline = colorResource(R.color.outline)
    )

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorSchemeFromResources(),
        content = content
    )
}
package com.buscar.farmaciapopular.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Vaccines
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Vaccines
import androidx.compose.ui.graphics.vector.ImageVector
import com.buscar.farmaciapopular.R

sealed class Screen(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val title: Int,
    @StringRes val contentDescription: Int,
) {
    data object Pharmacies : Screen(
        "pharmacies",
        Icons.Filled.Home,
        Icons.Outlined.Home,
        R.string.navigation_pharmacies,
        R.string.navigation_pharmacies_content_description
    )

    data object Medicines : Screen(
        "medicines",
        Icons.Filled.Vaccines,
        Icons.Outlined.Vaccines,
        R.string.navigation_medicines,
        R.string.navigation_medicines_content_description
    )

    data object Settings : Screen(
        "settings",
        Icons.Filled.Settings,
        Icons.Outlined.Settings,
        R.string.navigation_settings,
        R.string.navigation_settings_content_description
    )
}
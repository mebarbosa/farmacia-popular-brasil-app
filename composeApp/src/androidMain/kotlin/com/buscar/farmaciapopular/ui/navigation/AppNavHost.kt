package com.buscar.farmaciapopular.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buscar.farmaciapopular.ui.views.MedicinesScreen
import com.buscar.farmaciapopular.ui.views.PharmaciesScreen
import com.buscar.farmaciapopular.ui.views.SettingsScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Pharmacies.route) {
        composable(Screen.Pharmacies.route) { PharmaciesScreen() }
        composable(Screen.Medicines.route) { MedicinesScreen() }
        composable(Screen.Settings.route) { SettingsScreen() }
    }
}
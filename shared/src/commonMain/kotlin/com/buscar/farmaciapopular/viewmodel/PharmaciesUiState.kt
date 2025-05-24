package com.buscar.farmaciapopular.viewmodel

import com.buscar.farmaciapopular.data.model.Pharmacy

sealed class PharmaciesUiState {
    data object Loading : PharmaciesUiState()

    data class Success(val pharmacies: List<Pharmacy>) : PharmaciesUiState()

    data class Error(val message: String) : PharmaciesUiState()

    data object Empty : PharmaciesUiState()

    data object Idle : PharmaciesUiState()
}
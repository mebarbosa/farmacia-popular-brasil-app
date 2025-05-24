package com.buscar.farmaciapopular.viewmodel

import com.buscar.farmaciapopular.data.repository.PharmacyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PharmaciesViewModel(
    private val pharmacyRepository: PharmacyRepository,
) {
    private val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private val _uiState = MutableStateFlow<PharmaciesUiState>(PharmaciesUiState.Idle)
    val uiState: StateFlow<PharmaciesUiState> = _uiState.asStateFlow()

    fun loadPharmacies() {
        _uiState.value = PharmaciesUiState.Loading

        viewModelScope.launch {
            try {
                val pharmacies = pharmacyRepository.getPharmacies()

                if (pharmacies.isEmpty()) {
                    _uiState.value = PharmaciesUiState.Empty
                } else {
                    _uiState.value = PharmaciesUiState.Success(pharmacies)
                }
            } catch (e: Exception) {
                _uiState.value = PharmaciesUiState.Error("Error while fetching data")
            }
        }
    }

    fun clear() {
        viewModelScope.coroutineContext.cancel()
    }
}
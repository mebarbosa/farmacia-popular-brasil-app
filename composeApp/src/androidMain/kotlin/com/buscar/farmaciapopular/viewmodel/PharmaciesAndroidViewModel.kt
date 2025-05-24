package com.buscar.farmaciapopular.viewmodel

import androidx.lifecycle.ViewModel
import com.buscar.farmaciapopular.data.repository.PharmacyRepository
import kotlinx.coroutines.flow.StateFlow

class PharmaciesAndroidViewModel(
    pharmacyRepository: PharmacyRepository
) : ViewModel() {
    private val delegate = PharmaciesViewModel(pharmacyRepository)
    val uiState: StateFlow<PharmaciesUiState> = delegate.uiState

    fun loadPharmacies() = delegate.loadPharmacies()

    override fun onCleared() {
        super.onCleared()
        delegate.clear()
    }
}
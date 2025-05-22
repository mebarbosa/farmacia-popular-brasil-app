package com.buscar.farmaciapopular.data.repository

import com.buscar.farmaciapopular.data.model.Pharmacy

interface PharmacyRepository {
    suspend fun getPharmacies(): List<Pharmacy>
}
package com.buscar.farmaciapopular.data.local

import com.buscar.farmaciapopular.data.model.Pharmacy

interface LocalDataSource {
    suspend fun getAllPharmacies(): List<Pharmacy>
}
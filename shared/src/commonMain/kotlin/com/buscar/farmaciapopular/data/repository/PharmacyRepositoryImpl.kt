package com.buscar.farmaciapopular.data.repository

import com.buscar.farmaciapopular.data.local.LocalDataSource
import com.buscar.farmaciapopular.data.model.Pharmacy

class PharmacyRepositoryImpl(
    private val localDataSource: LocalDataSource
) : PharmacyRepository {
    override suspend fun getPharmacies(): List<Pharmacy> {
        return localDataSource.getAllPharmacies()
    }
}
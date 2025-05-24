package com.buscar.farmaciapopular.di

import com.buscar.farmaciapopular.data.local.LocalDataSource
import com.buscar.farmaciapopular.data.local.LocalDataSourceImpl
import com.buscar.farmaciapopular.data.repository.PharmacyRepository
import com.buscar.farmaciapopular.data.repository.PharmacyRepositoryImpl
import com.buscar.farmaciapopular.viewmodel.PharmaciesViewModel
import org.koin.dsl.module

val commonModule =
    module {
        single<LocalDataSource> { LocalDataSourceImpl() }
        single<PharmacyRepository> { PharmacyRepositoryImpl(get()) }
        factory { PharmaciesViewModel(get()) }
    }
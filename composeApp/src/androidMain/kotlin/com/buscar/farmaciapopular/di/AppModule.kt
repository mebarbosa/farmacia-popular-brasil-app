package com.buscar.farmaciapopular.di

import com.buscar.farmaciapopular.data.repository.PharmacyRepository
import com.buscar.farmaciapopular.viewmodel.PharmaciesAndroidViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        viewModel { PharmaciesAndroidViewModel(get<PharmacyRepository>()) }
    }
package com.buscar.farmaciapopular.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

typealias KoinAppDeclaration = KoinApplication.() -> Unit

fun appModule() = listOf(commonModule, platformDataModule)

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(appModule())
    }
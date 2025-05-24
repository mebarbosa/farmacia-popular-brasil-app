package com.buscar.farmaciapopular

import android.app.Application
import com.buscar.farmaciapopular.di.appModule
import com.buscar.farmaciapopular.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@App)
        }
        loadKoinModules(appModule)
    }
}
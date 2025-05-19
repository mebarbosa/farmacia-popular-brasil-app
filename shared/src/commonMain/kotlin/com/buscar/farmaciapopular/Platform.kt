package com.buscar.farmaciapopular

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
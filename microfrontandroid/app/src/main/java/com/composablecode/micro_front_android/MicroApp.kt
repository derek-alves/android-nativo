package com.composablecode.micro_front_android


import androidx.navigation.NavGraphBuilder


interface MicroApp {
    fun pages(registryService: RegistryService)
}

fun NavGraphBuilder.registerMicroApps(
    microApps: List<MicroApp>,
    registryService: RegistryService
) {
    microApps.forEach { app ->
        with(this) {
            app.pages(registryService)
            registryService.getRegisteredPages().forEach { page ->
                page.register(this)
            }
        }
    }
}


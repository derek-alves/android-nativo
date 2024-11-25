package com.composablecode.micro_front_android


class RegistryService() {
    private val registeredPages = mutableListOf<Page<AppRoute>>()

    fun addPage(page: Page<AppRoute>) {
        registeredPages.add(page)
    }

    fun getRegisteredPages(): MutableList<Page<AppRoute>> {
        return registeredPages
    }
}
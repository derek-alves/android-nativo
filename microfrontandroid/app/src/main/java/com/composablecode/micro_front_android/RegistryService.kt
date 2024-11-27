package com.composablecode.micro_front_android

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlin.reflect.KClass


object RegistryService {
    private val registeredPages = mutableListOf<Page<AppRoute>>()

    @PublishedApi
    internal val factories: MutableMap<KClass<out AppRoute>, (AppRoute) -> Page<AppRoute>> =
        mutableMapOf()

    fun addPage(page: Page<AppRoute>) {
        registeredPages.add(page)
    }

    inline fun <reified T : AppRoute> register(noinline factory: (T) -> Page<T>) {
        factories[T::class] = factory as (AppRoute) -> Page<AppRoute>
    }

    fun getRegisteredPages(): MutableList<Page<AppRoute>> {
        return registeredPages
    }

    fun get(provider: AppRoute): Page<AppRoute> {
        val factory = factories[provider::class]
            ?: error("ScreenProvider not registered: ")
        return factory(provider)
    }
}

@Composable
fun rememberScreen(provider: AppRoute): Page<AppRoute> =
    remember(provider) {
        RegistryService.get(provider)
    }
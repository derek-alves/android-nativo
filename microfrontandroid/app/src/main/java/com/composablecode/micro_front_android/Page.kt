package com.composablecode.micro_front_android

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestinationBuilder
import androidx.navigation.NavDestinationDsl
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.ComposeNavigatorDestinationBuilder
import androidx.navigation.get
import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.jvm.jvmErasure

@NavDestinationDsl
class PageBuilder public constructor(
    navigator: ComposeNavigator,
    route: KClass<*>,
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>>,
    private val content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) : NavDestinationBuilder<ComposeNavigator.Destination>(navigator, route, typeMap) {
    private val composeNavigator: ComposeNavigator = navigator

    override fun instantiateDestination(): ComposeNavigator.Destination {
        return ComposeNavigator.Destination(composeNavigator, content)
    }

}


class Page<T: AppRoute>(
    private val route: T,
    private val typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    private val deepLinks: List<String> = emptyList(),
    private  val content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    fun register(navGraphBuilder: NavGraphBuilder) {
        val navigator = navGraphBuilder.provider[ComposeNavigator::class] as ComposeNavigator
        navGraphBuilder.destination(
            PageBuilder(
                navigator = navigator,
                route = route::class,
                typeMap = typeMap,
                content = content
            ).apply {
                deepLinks.forEach { deepLink -> deepLink(deepLink) }
            }
        )
    }
}


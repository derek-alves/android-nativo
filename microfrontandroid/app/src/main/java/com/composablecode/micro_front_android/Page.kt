package com.composablecode.micro_front_android

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestinationBuilder
import androidx.navigation.NavDestinationDsl
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.ComposeNavigatorDestinationBuilder
import androidx.navigation.get
import kotlin.reflect.KClass
import kotlin.reflect.KType

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


class Page<T : AppRoute>(
    private val route: T,
    private val typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    private val deepLinks: List<String> = emptyList(),
    private val content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
) {
    fun register(
        navGraphBuilder: NavGraphBuilder,
        enterTransition:
        (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
        EnterTransition?)? =
            null,
        exitTransition:
        (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
        ExitTransition?)? =
            null,
        popEnterTransition:
        (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
        EnterTransition?)? =
            enterTransition,
        popExitTransition:
        (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
        ExitTransition?)? =
            exitTransition,
        sizeTransform:
        (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
        SizeTransform?)? =
            null,
    ) {
        val navigator = navGraphBuilder.provider[ComposeNavigator::class] as ComposeNavigator
        navGraphBuilder.destination(
            ComposeNavigatorDestinationBuilder(
                navigator = navigator,
                route = route::class,
                typeMap = typeMap,
                content = content
            ).apply {
                deepLinks.forEach { deepLink -> deepLink(deepLink) }
                this.enterTransition = enterTransition
                this.exitTransition = exitTransition
                this.popEnterTransition = popEnterTransition
                this.popExitTransition = popExitTransition
                this.sizeTransform = sizeTransform
            }
        )
    }
}


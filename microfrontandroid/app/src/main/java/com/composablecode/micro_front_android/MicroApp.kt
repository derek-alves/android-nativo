package com.composablecode.micro_front_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlin.reflect.KClass

interface MicroApp {
    fun registerPages(navigationService: NavigationService)
    fun registerRoutes(builder: NavGraphBuilder)
}

//class Page<T : AppRoute>(val content: @Composable () -> Unit) {
//    inline fun <reified T : AppRoute>  addPage(builder: NavGraphBuilder){
//         builder.composable<T>{
//            content()
//            }
//    }
//}

 class Page<out T : AppRoute>(val route: T, val content: @Composable () -> Unit)


 fun <T: AppRoute> MicroApp.addPage(route: KClass<T>, content: @Composable () -> Unit){
    NavigatorServiceProvider.I.registerPage(route, content)
}

fun NavGraphBuilder.registerMicroApps(microApps: List<MicroApp>) {
    microApps.forEach { app ->
        with(this) {
            app.registerRoutes(this)
            app.registerPages(NavigatorServiceProvider.I)
            NavigatorServiceProvider.I.getRegisteredPages().forEach(fun(
                route: KClass<out AppRoute>,
                page: @Composable () -> Unit
            ) {

                composable<route> { page() }
            })
        }
    }
}
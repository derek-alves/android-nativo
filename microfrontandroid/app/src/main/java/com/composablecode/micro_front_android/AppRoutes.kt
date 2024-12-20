package com.composablecode.micro_front_android

import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoute {

    @Serializable
    data object Home : AppRoute()

    @Serializable
    data object HomeDetails : AppRoute()

    @Serializable
    data object HomeSettings : AppRoute()

    @Serializable
    data class Profile(val userId: String) : AppRoute()

    @Serializable
    data object ProfileSettings : AppRoute()
}


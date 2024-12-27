package com.composablecode.voyagerstudy.application.infra.routes

import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.koin.ktor.ext.get

fun Application.serverRouter() {
    routing {
        tweetRoutes(get())
    }
}
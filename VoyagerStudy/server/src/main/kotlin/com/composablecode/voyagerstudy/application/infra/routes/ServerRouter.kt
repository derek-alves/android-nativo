package com.composablecode.voyagerstudy.application.infra.routes

import com.composablecode.voyagerstudy.application.ports.incoming.TweetQueryPort
import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject


fun Application.serverRouter() {
    val myService: TweetQueryPort by inject()
    routing {
        tweetRoutes(myService)
    }
}
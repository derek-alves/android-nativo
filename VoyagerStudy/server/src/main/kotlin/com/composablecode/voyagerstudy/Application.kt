package com.composablecode.voyagerstudy

import com.composablecode.voyagerstudy.application.infra.di.serverModule
import com.composablecode.voyagerstudy.application.infra.routes.serverRouter
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.get
import org.koin.ktor.plugin.Koin


fun main() {
    embeddedServer(
        Netty,
        port = HTTP_PORT,
        host = HTTP_HOST,
        module = Application::module
    )
        .start(wait = true)
}

fun Application.module() {
    install(Koin) {
        modules(serverModule)
    }
    install(ContentNegotiation) {
        json(get<Json>())
    }
    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.AccessControlAllowOrigin)
        allowMethod(HttpMethod.Delete)
    }
    serverRouter()
}
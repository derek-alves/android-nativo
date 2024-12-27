package com.composablecode.voyagerstudy

import com.composablecode.voyagerstudy.infra.di.serverModule
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
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
    val jsonInstance = get<Json>()
    install(ContentNegotiation) {
        json(jsonInstance)
    }
    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.AccessControlAllowOrigin)
        allowMethod(HttpMethod.Delete)
    }
    routing {
        get("/") {
            call.respondText("Ktor: 'test'}")
        }
    }
}
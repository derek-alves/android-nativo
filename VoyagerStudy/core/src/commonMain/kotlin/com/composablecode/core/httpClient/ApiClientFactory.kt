package com.composablecode.core.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json


object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true;
                    isLenient = true
                    isLenient = true
                    
                })
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
        }
    }
}
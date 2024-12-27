package com.composablecode.voyagerstudy.infra.di

import com.composablecode.voyagerstudy.infra.database.DatabaseDriverFactory
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val serverModule = module {
    single {
        DatabaseDriverFactory()
    }
    single {
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}
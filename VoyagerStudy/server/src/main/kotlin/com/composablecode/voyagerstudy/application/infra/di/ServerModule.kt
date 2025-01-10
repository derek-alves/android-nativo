package com.composablecode.voyagerstudy.application.infra.di

import com.composablecode.voyagerstudy.application.adapters.TweetRepositoryImpl
import com.composablecode.voyagerstudy.application.infra.database.DatabaseManager
import com.composablecode.voyagerstudy.application.infra.database.SqlDelightService
import com.composablecode.voyagerstudy.application.ports.incoming.TweetQueryPort
import com.composablecode.voyagerstudy.application.ports.outgoing.TweetRepository
import com.composablecode.voyagerstudy.application.services.TweetService
import com.composablecode.voyagerstudy.application.utils.mappers.TweetMapper
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val serverModule = module {
    single { SqlDelightService() }
    single { TweetMapper() }
    single { DatabaseManager(get()) }
    factory<TweetRepository> { TweetRepositoryImpl(get(), get()) }
    factory<TweetQueryPort> { TweetService(get()) }
    single {
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}
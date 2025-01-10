plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.sqlDelight)
    application
}

group = "com.composablecode.voyagerstudy"
version = "1.0.0"
application {
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")

    mainClass.set("com.composablecode.voyagerstudy.ApplicationKt")
//        listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "true"}")
}

dependencies {
    implementation(projects.core)
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(project(":core"))
    testImplementation(libs.kotlin.test.junit)
    implementation(libs.koin.core)
    implementation(libs.koin.ktor)

    implementation(libs.logback)
    implementation(libs.kotlinx.serialization.json)
    testImplementation(libs.ktor.server.tests)
    // Koin
    implementation(libs.koin.core)
    implementation(libs.koin.ktor)
    // Ktor
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.config.yaml)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    // DB
    implementation(libs.postgresql)
    implementation(libs.hikari.cp)
    implementation(libs.jdbc.driver)
}

sqldelight {
    databases {
        create("ServerDatabase") {
            packageName = "com.composablecode.voyagerstudy"
            dialect("app.cash.sqldelight:postgresql-dialect:2.0.2")
        }
    }
}
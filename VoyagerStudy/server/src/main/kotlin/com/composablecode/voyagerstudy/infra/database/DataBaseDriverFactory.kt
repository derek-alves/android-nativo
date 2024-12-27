package com.composablecode.voyagerstudy.infra.database

class DatabaseDriverFactory {
    init {
        SqlDelightService().createDriver(
            jdbcUrl = "jdbc:postgresql://db:5432/study",
            driverClassName = "org.postgresql.Driver",
            username = "any-username",
            password = "any-password",
        )
    }
}
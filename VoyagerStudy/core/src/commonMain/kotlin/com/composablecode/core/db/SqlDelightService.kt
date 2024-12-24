package com.composablecode.core.db

import app.cash.sqldelight.db.SqlDriver

class SqlDelightService : DBService<SqlDriver> {
    override fun createDriver(
        jdbcUrl: String,
        driverClassName: String,
        username: String,
        password: String,
        maxPoolSize: Int,
        minIdle: Int,
        idleTimeout: Long,
        connectionTimeout: Long,
        maxLifetime: Long
    ): SqlDriver {
        TODO("Not yet implemented")
    }

    override fun closeDriver() {
        TODO("Not yet implemented")
    }
}
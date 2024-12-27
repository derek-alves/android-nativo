package com.composablecode.core.db

interface DBService<T> {
    fun createDriver(
        jdbcUrl: String,
        driverClassName: String,
        username: String,
        password: String,
        maxPoolSize: Int = 5,
        minIdle: Int = 2,
        idleTimeout: Long = 10000,
        connectionTimeout: Long = 30000,
        maxLifetime: Long = 1800000,
    ): T

}
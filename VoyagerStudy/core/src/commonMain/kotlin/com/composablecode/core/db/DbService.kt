package com.composablecode.core.db

interface DBService<T> {
    fun createDriver(
        jdbcUrl: String,
        driverClassName: String,
        username: String,
        password: String,
        maxPoolSize: Int,
        minIdle: Int,
        idleTimeout: Long,
        connectionTimeout: Long,
        maxLifetime: Long
    ): T

    
}
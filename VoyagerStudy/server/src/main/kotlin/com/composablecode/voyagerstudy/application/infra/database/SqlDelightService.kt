package com.composablecode.voyagerstudy.application.infra.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.asJdbcDriver
import com.composablecode.core.db.DBService
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource


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
        val config = HikariConfig().apply {
            this.jdbcUrl = jdbcUrl
            this.driverClassName = driverClassName
            this.username = username
            this.password = password

            maximumPoolSize = 5
            minimumIdle = 2
            this.idleTimeout = 10000
            this.connectionTimeout = 30000
            this.maxLifetime = 1800000
        }
        val dataSource = HikariDataSource(config)
        return dataSource.asJdbcDriver()
    }


}
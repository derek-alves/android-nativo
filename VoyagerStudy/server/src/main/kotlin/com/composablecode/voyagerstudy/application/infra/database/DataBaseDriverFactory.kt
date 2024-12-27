package com.composablecode.voyagerstudy.application.infra.database

import com.composablecode.voyagerstudy.DB_USER_NAME
import com.composablecode.voyagerstudy.DB_USER_PASSWORD
import com.composablecode.voyagerstudy.DRIVER_CLASS_NAME
import com.composablecode.voyagerstudy.JDBC_URL
import com.composablecode.voyagerstudy.ServerDatabase
import com.composablecode.voyagerstudy.ServerDatabase.Companion.Schema
import com.composablecode.voyagerstudy.ServerDatabaseQueries


class DatabaseManager(private val sqlDelightService: SqlDelightService) {
    private val database: ServerDatabase by lazy {
        val driver = sqlDelightService.createDriver(
            jdbcUrl = System.getenv("JDBC_URL") ?: JDBC_URL,
            driverClassName = System.getenv("DRIVER_CLASS_NAME") ?: DRIVER_CLASS_NAME,
            username = System.getenv("DB_USER_NAME") ?: DB_USER_NAME,
            password = System.getenv("DB_USER_PASSWORD") ?: DB_USER_PASSWORD,
        )
        Schema.create(driver)
        ServerDatabase(driver)
    }

    val queries: ServerDatabaseQueries
        get() = database.serverDatabaseQueries
}

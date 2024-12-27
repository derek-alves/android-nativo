package com.composablecode.voyagerstudy.application.utils.mappers

import java.time.LocalDateTime
import java.time.ZoneOffset

object EpochMillisMapper {
    fun toEpochMillis(localDateTime: LocalDateTime?): Long? {
        return localDateTime?.toInstant(ZoneOffset.UTC)?.toEpochMilli()
    }

    fun fromEpochMillis(epochMillis: Long?): LocalDateTime? {
        return epochMillis?.let {
            LocalDateTime.ofEpochSecond(
                it / 1000, // Segundos
                (it % 1000 * 1_000_000).toInt(), // Nanos
                ZoneOffset.UTC
            )
        }
    }
}

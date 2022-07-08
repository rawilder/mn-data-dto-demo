package dev.awilder

import io.micronaut.core.annotation.Introspected

@Introspected
data class TestEntityDto(
    val id: Long,
    val name: String
)

package com.demo.database

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class DatabaseApplication

fun main(args: Array<String>) {
    runApplication<DatabaseApplication>(*args)
}

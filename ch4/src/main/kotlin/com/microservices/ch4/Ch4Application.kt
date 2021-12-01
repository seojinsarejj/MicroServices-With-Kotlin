package com.microservices.ch4

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch4Application

fun main(args: Array<String>) {
	runApplication<Ch4Application>(*args)
}

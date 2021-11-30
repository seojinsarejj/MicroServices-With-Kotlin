package com.microservices.ch3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class Ch3Application

fun main(args: Array<String>) {
	runApplication<Ch3Application>(*args)
}

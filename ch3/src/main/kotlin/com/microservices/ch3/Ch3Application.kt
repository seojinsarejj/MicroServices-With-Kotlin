package com.microservices.ch3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch3Application

fun main(args: Array<String>) {
	runApplication<Ch3Application>(*args)
}

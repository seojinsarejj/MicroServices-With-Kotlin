package com.microservices.ch3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class Ch3Application {
	companion object {
		val initialCutomers = arrayOf(Customer(1, "Kotlin"),
			Customer(2,"Spring"),
			Customer(3,"Microservice"))
	}

	@Bean
	fun customer() = ConcurrentHashMap<Int,Customer>(initialCutomers.associateBy(Customer::id))
}

fun main(args: Array<String>) {
	runApplication<Ch3Application>(*args)
}

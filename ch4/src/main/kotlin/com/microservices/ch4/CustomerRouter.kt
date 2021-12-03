package com.microservices.ch4

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.toMono
import reactor.kotlin.core.publisher.toMono

@Component
class CustomerRouter {
    @Bean
    fun customerRoutes() = router {
        "/functional".nest {
            "/customer".nest{
                GET("/") {
                    ok().body(Customer(1, "functional web").toMono(), Customer::class.java)
                }
            }
        }
    }
}